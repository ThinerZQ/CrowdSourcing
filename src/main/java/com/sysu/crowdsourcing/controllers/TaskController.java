package com.sysu.crowdsourcing.controllers;


import com.sysu.crowdsourcing.entity.CrowdSourcingTask;
import com.sysu.crowdsourcing.entity.DecomposeTask;
import com.sysu.crowdsourcing.entity.DecomposeVoteTask;
import com.sysu.crowdsourcing.entity.JudgeTask;
import com.sysu.crowdsourcing.exceptions.SCXMLExecuteException;
import com.sysu.crowdsourcing.services.CrowdSourcingTaskService;
import com.sysu.crowdsourcing.services.DecomposeTaskService;
import com.sysu.crowdsourcing.services.DecomposeVoteTaskService;
import com.sysu.crowdsourcing.services.JudgeTaskService;
import com.sysu.workflow.SCXMLExecutor;
import com.sysu.workflow.TriggerEvent;
import com.sysu.workflow.engine.SCXMLInstanceManager;
import com.sysu.workflow.entity.GroupEntity;
import com.sysu.workflow.entity.GroupWorkItemEntity;
import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.entity.UserWorkItemEntity;
import com.sysu.workflow.service.taskservice.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
@Controller
public class TaskController {

    @Resource(name = "crowdSourcingTaskService")
    CrowdSourcingTaskService crowdSourcingTaskService;

    @Resource(name = "judgeTaskService")
    JudgeTaskService judgeTaskService;

    @Resource(name = "decomposeTaskService")
    DecomposeTaskService decomposeTaskService;

    @Resource(name = "decomposeVoteTaskService")
    DecomposeVoteTaskService decomposeVoteTaskService;

    @RequestMapping("/Home.do")
    public ModelAndView Home() {

        System.out.println("--------Home----------");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/myTask.do");
        return modelAndView;
    }

    @RequestMapping("/myTask.do")
    public ModelAndView myTask(HttpSession httpSession) {

        System.out.println("--------myTask.do----------");
        System.out.println("--------load my workitem----------");

        ModelAndView modelAndView = new ModelAndView();
        UserEntity currentUserEntity = (UserEntity) httpSession.getAttribute("currentUserEntity");
        ArrayList<UserWorkItemEntity> userWorkItemEntityList = TaskService.createUserTaskQuery().taskAssignee(currentUserEntity).taskFinish(null).list();

        Map<GroupEntity, ArrayList<GroupWorkItemEntity>> groupWorkItemArrayListMap = new LinkedHashMap<GroupEntity, ArrayList<GroupWorkItemEntity>>();
        //得到当前用户所在组的所有工作项
        for (GroupEntity groupEntity : currentUserEntity.getGroupEntitySet()) {
            ArrayList<GroupWorkItemEntity> groupWorkItemEntityArrayList = TaskService.createGroupTaskQuery().taskCandidateGroup(groupEntity).list();

            //当前组有任务，就加入到map里面
            if (groupWorkItemEntityArrayList.size() != 0) {
                groupWorkItemArrayListMap.put(groupEntity, groupWorkItemEntityArrayList);
            }
            //剔除包含在用户任务列表里面的任务
            for (UserWorkItemEntity uwie : userWorkItemEntityList) {
                int size = groupWorkItemEntityArrayList.size();
                for (int i = 0; i < size; i++) {
                    GroupWorkItemEntity gwie = groupWorkItemEntityArrayList.get(i);
                    if (gwie.getItemProcessId().equals(uwie.getItemProcessId()) && gwie.getItemStateId().equals(uwie.getItemStateId()) && gwie.getItemName().equals(uwie.getItemName())) {
                        groupWorkItemEntityArrayList.remove(gwie);
                        size--;
                    }
                }
            }
            //当前组有任务，就加入到map里面
            if (groupWorkItemEntityArrayList.size() != 0) {
                groupWorkItemArrayListMap.put(groupEntity, groupWorkItemEntityArrayList);
            } else {
                groupWorkItemArrayListMap.remove(groupEntity);
            }
        }
        int size = userWorkItemEntityList.size();
        for (int i = 0; i < size; i++) {
            if (userWorkItemEntityList.get(i).getItemFinish().equals("yes")) {
                userWorkItemEntityList.remove(i);
                size--;
            }
        }

        modelAndView.addObject("userWorkItemEntityList", userWorkItemEntityList);
        modelAndView.addObject("groupWorkItemArrayListMap", groupWorkItemArrayListMap);
        modelAndView.setViewName("myTask");
        return modelAndView;
    }

    @RequestMapping("/signIn.do")
    public ModelAndView signIn(String groupWorkItemId, HttpSession httpSession) {
        System.out.println("--------signIn.do----------");

        ModelAndView modelAndView = new ModelAndView();
        UserEntity currentUserEntity = (UserEntity) httpSession.getAttribute("currentUserEntity");

        System.out.println(groupWorkItemId);
        TaskService taskService = new TaskService();
        if (groupWorkItemId != null) {
            GroupWorkItemEntity groupWorkItemEntity = TaskService.createGroupTaskQuery().taskId(Integer.parseInt(groupWorkItemId)).SingleResult();
            //更新group workitem
            int instance;
            instance = groupWorkItemEntity.getItemInstances();
            if (groupWorkItemEntity.getItemInstances() <= 0) {
                //返回，提示组任务被做完了。
                System.out.println("group work done ");
            } else {

                UserWorkItemEntity userWorkItemEntity = taskService.newWorkItem();
                //保存user workitem
                userWorkItemEntity.setItemName(groupWorkItemEntity.getItemName())
                        .setItemCreateTime(new Date().toLocaleString())
                        .setItemStateId(groupWorkItemEntity.getItemStateId())
                        .setItemProcessId(groupWorkItemEntity.getItemProcessId())
                        .setItemAssigneeEntity(currentUserEntity)
                        .setItemFormEntity(groupWorkItemEntity.getItemFormEntity())
                        .setItemGroupWorkItemEntity(groupWorkItemEntity)
                        .setItemProcessInstanceEntity(groupWorkItemEntity.getItemProcessInstanceEntity());
                taskService.saveUserWorkItem(userWorkItemEntity);

                instance = groupWorkItemEntity.getItemInstances() - 1;
                groupWorkItemEntity.setItemInstances(instance);
                taskService.updateGroupWorkItem(groupWorkItemEntity);
                modelAndView.setViewName("redirect:/myTask.do");
            }
        }
        return modelAndView;
    }

    @RequestMapping("/userTaskDetail.do")
    public ModelAndView userTaskDetail(String userWorkItemId, HttpSession httpSession) {
        System.out.println("--------taskDetail.do----------");

        ModelAndView modelAndView = new ModelAndView();

        System.out.println(userWorkItemId);
        TaskService taskService = new TaskService();
        if (userWorkItemId != null) {
            UserWorkItemEntity userWorkItemEntity = taskService.createUserTaskQuery().taskId(Integer.parseInt(userWorkItemId)).SingleResult();
            CrowdSourcingTask crowdSourcingTask = crowdSourcingTaskService.getCrowdSourcingTaskByProcessInstanceId(userWorkItemEntity.getItemProcessInstanceEntity().getId());
            String currentState = userWorkItemEntity.getItemProcessInstanceEntity().getProcessInstanceCurrentState();


            if (userWorkItemEntity.getItemName().equals("DecomposeVoteTask")) {
                ArrayList<UserWorkItemEntity> decomposeTaskUserWorkflowEntity = TaskService.createUserTaskQuery().taskFinish("yes").taskName("DecomposeTask").taskProcessInstanceId(userWorkItemEntity.getItemProcessId()).list();

                Map<UserWorkItemEntity, ArrayList<DecomposeTask>> decomposeTaskUserWorkflowMap = new HashMap<UserWorkItemEntity, ArrayList<DecomposeTask>>();
                //get coorespond decompose result for each userworkflowEntity
                for (UserWorkItemEntity tempEntity : decomposeTaskUserWorkflowEntity) {
                    DecomposeTask tempDecomposeTask = new DecomposeTask();
                    tempDecomposeTask.setUserWorkItemEntity(tempEntity);
                    ArrayList<DecomposeTask> decomposeTaskArrayList = decomposeTaskService.getDecomposeTasks(tempDecomposeTask);
                    decomposeTaskUserWorkflowMap.put(tempEntity, decomposeTaskArrayList);
                }
                modelAndView.addObject("decomposeTaskUserWorkflowMap", decomposeTaskUserWorkflowMap);
            }


            modelAndView.addObject("userWorkItemEntity", userWorkItemEntity);
            modelAndView.addObject("crowdSourcingTask", crowdSourcingTask);


            modelAndView.addObject("currentState", currentState);
            modelAndView.setViewName("taskDetail");
        }

        return modelAndView;
    }



    @RequestMapping("/groupTaskDetail.do")
    public ModelAndView groupTaskDetail(String groupWorkItemId, HttpSession httpSession) {
        System.out.println("--------taskDetail.do----------");

        ModelAndView modelAndView = new ModelAndView();
        UserEntity currentUserEntity = (UserEntity) httpSession.getAttribute("currentUserEntity");

        System.out.println(groupWorkItemId);
        TaskService taskService = new TaskService();
        if (groupWorkItemId != null) {
            GroupWorkItemEntity groupWorkItemEntity = taskService.createGroupTaskQuery().taskId(Integer.parseInt(groupWorkItemId)).SingleResult();
            modelAndView.addObject("groupWorkItemEntity", groupWorkItemEntity);
            modelAndView.setViewName("taskDetail");
        }
        return modelAndView;
    }


    @RequestMapping("/judgeTask.do")
    public ModelAndView judgeTask(HttpSession httpSession) {

        System.out.println("--------judgeTask.do----------");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myTask.do?taskState=judging");
        return modelAndView;
    }

    @RequestMapping("/completeJudgeTask.do")
    public ModelAndView completeJudgeTask(@ModelAttribute JudgeTask judgeTask, String userWorkItemId, HttpSession httpSession) {

        System.out.println("--------completeJudgeTask.do----------");

        ModelAndView modelAndView = new ModelAndView();

        judgeTask.setTaskCompleteTime(new Date());
        System.out.println(judgeTask.toString());
        System.out.println(userWorkItemId);
        UserWorkItemEntity userWorkItemEntity = null;
        try {
            if (userWorkItemId != null) {
                userWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(userWorkItemId)).SingleResult();
                judgeTask.setUserWorkItemEntity(userWorkItemEntity);
            }
            if (judgeTask.getUserWorkItemEntity() == null) {
                modelAndView.setViewName("error");
                return modelAndView;
            }
            long id = judgeTaskService.saveJudgeTask(judgeTask);
            //save result sucess ,then update itemFinish to yes
            if (id != -1) {
                userWorkItemEntity.setItemFinish("yes");
                TaskService taskService = new TaskService();
                taskService.updateUserWorkItem(userWorkItemEntity);

                int simple = -1;
                //notify scxml executor
                if ("complex".equals(judgeTask.getProperty())) {
                    simple = 1;
                } else if ("simple".equals(judgeTask.getProperty())) {
                    simple = 0;
                }
                Map<String, Object> dataMap = new HashMap<String, Object>();
                dataMap.put("simple", simple);
                System.out.println(SCXMLInstanceManager.getRunningSCXMLInstanceExecutorMap());
                SCXMLExecutor executor = SCXMLInstanceManager.getSCXMLInstanceExecutor(userWorkItemEntity.getItemProcessId());
                if (executor == null) {
                    throw new SCXMLExecuteException("no executor exception");
                }
                executor.triggerEvent(new TriggerEvent("judgeComplete", TriggerEvent.SIGNAL_EVENT, dataMap));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("redirect:/myTask.do?taskState=judging");
        return modelAndView;
    }

    @RequestMapping("/completeDecomposeTask.do")
    public ModelAndView completeDecomposeTask(String userWorkItemId, String steps, String stepName[], String order[], String stepDescription[]) {

        System.out.println("--------completeDecomposeTask.do----------");

        ModelAndView modelAndView = new ModelAndView();

        int step = 0;

        //写入decomposeVoteTask
        if (userWorkItemId != null && steps != null && (step = Integer.parseInt(steps)) > 0) {
            UserWorkItemEntity userWorkItemEntity = null;
            try {
                userWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(userWorkItemId)).SingleResult();
                if (userWorkItemEntity == null) {
                    modelAndView.setViewName("error");
                    return modelAndView;
                }

                ArrayList<DecomposeTask> decomposeTasks = new ArrayList<DecomposeTask>();
                for (int i = 0; i <= step; i++) {

                    DecomposeTask decomposeTask = new DecomposeTask();
                    decomposeTask.setTaskCompleteTime(new Date());

                    String tempOrder = order[i];
                    String tempStepName = stepName[i];
                    String tempStepDescription = stepDescription[i];

                    decomposeTask.setUserWorkItemEntity(userWorkItemEntity);
                    decomposeTask.setTaskName(tempStepName);
                    decomposeTask.setTaskOrder(tempOrder);
                    decomposeTask.setTaskDescription(tempStepDescription);

                    decomposeTasks.add(decomposeTask);
                }

                boolean flag = decomposeTaskService.saveDecomposeTask(decomposeTasks);

                //save result sucess ,then update itemFinish to yes
                if (flag) {
                    userWorkItemEntity.setItemFinish("yes");
                    TaskService taskService = new TaskService();
                    taskService.updateUserWorkItem(userWorkItemEntity);

                    SCXMLExecutor executor = SCXMLInstanceManager.getSCXMLInstanceExecutor(userWorkItemEntity.getItemProcessId());
                    if (executor == null) {
                        throw new SCXMLExecuteException("no  executor exception");
                    }
                    executor.triggerEvent(new TriggerEvent("decomposeComplete", TriggerEvent.SIGNAL_EVENT));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        modelAndView.setViewName("redirect:/myTask.do?taskState=decomposing");
        return modelAndView;
    }

    @RequestMapping("/decomposeVoteTask.do")
    public ModelAndView decomposeVoteTask() {

        System.out.println("--------decomposeVoteTask.do----------");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myTask.do?taskState=decomposeVoting");
        return modelAndView;
    }

    @RequestMapping("/completeDecomposeVoteTask.do")
    public ModelAndView completeDecomposeVoteTask(String userWorkItemId, String votedUserWorkItemId) {

        System.out.println("--------completeDecomposeVoteTask.do----------");

        ModelAndView modelAndView = new ModelAndView();

        //写入decomposeVoteTask
        if (userWorkItemId != null && votedUserWorkItemId != null) {
            UserWorkItemEntity userWorkItemEntity = null;
            UserWorkItemEntity votedUserWorkItemEntity = null;
            try {
                userWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(userWorkItemId)).SingleResult();
                votedUserWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(votedUserWorkItemId)).SingleResult();

                if (userWorkItemEntity == null || votedUserWorkItemEntity == null) {
                    modelAndView.setViewName("error");
                    return modelAndView;
                }
                ArrayList<DecomposeTask> voteDecomposeTask = new ArrayList<DecomposeTask>();

                DecomposeTask tempDecomposeTask = new DecomposeTask();
                tempDecomposeTask.setUserWorkItemEntity(votedUserWorkItemEntity);
                voteDecomposeTask = decomposeTaskService.getDecomposeTasks(tempDecomposeTask);

                //save decomposeVoteTask
                DecomposeVoteTask decomposeVoteTask = new DecomposeVoteTask();
                decomposeVoteTask.setTaskCompleteTime(new Date());
                decomposeVoteTask.setUserWorkItemEntity(userWorkItemEntity);
                decomposeVoteTask.setDecomposeTaskSet(new HashSet<DecomposeTask>(voteDecomposeTask));


                // TODO :
                long id = decomposeVoteTaskService.saveDecomposeVoteTask(decomposeVoteTask);

                //save result sucess ,then update itemFinish to yes
                if (id != -1) {
                    userWorkItemEntity.setItemFinish("yes");
                    TaskService taskService = new TaskService();
                    taskService.updateUserWorkItem(userWorkItemEntity);

                    SCXMLExecutor executor = SCXMLInstanceManager.getSCXMLInstanceExecutor(userWorkItemEntity.getItemProcessId());
                    if (executor == null) {
                        throw new SCXMLExecuteException("no  executor exception");
                    }

                    //get the best decompose result
                    CrowdSourcingTask crowdSourcingTask = crowdSourcingTaskService.getCrowdSourcingTaskByProcessInstanceId(userWorkItemEntity.getItemProcessInstanceEntity().getId());

                    ArrayList<UserWorkItemEntity> tempUserWorkflowEntitys = TaskService.createUserTaskQuery().taskProcessInstanceId(userWorkItemEntity.getItemProcessId()).taskName("DecomposeTask").taskFinish("yes").list();
                    int votedCount = tempUserWorkflowEntitys.size();
                    //all people have been voted
                    Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
                    if (crowdSourcingTask.getTaskDecomposeVoteCount() == votedCount) {
                        //get the best decompose result
                        for (UserWorkItemEntity tempUserWorkflowEntity : tempUserWorkflowEntitys) {
                            DecomposeVoteTask condDecomposeVoteTask = new DecomposeVoteTask();
                            condDecomposeVoteTask.setUserWorkItemEntity(tempUserWorkflowEntity);
                            DecomposeVoteTask decomposeVoteTask1 = decomposeVoteTaskService.getDecomposeVoteTasks(condDecomposeVoteTask);

                            //get decomposeVoteTask's vote result
                            Set<DecomposeTask> decomposeTasks = decomposeVoteTask1.getDecomposeTaskSet();
                            for (DecomposeTask dt : decomposeTasks) {
                                int tempObj = tempMap.get((int) dt.getTaskId());
                                if (tempObj != 0)
                                    tempMap.put((int) dt.getTaskId(), tempObj + 1);
                                else
                                    tempMap.put((int) dt.getTaskId(), 1);
                            }
                        }
                    }

                    int max = 0;
                    int index = 0;
                    for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
                        if (max < entry.getValue()) {
                            max = entry.getValue();
                            index = entry.getKey();
                        }
                    }


                    //decomposeTaskService.getDecomposeTasks()


                    executor.triggerEvent(new TriggerEvent("decomposeVoteComplete", TriggerEvent.SIGNAL_EVENT));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        modelAndView.setViewName("redirect:/myTask.do?taskState=decomposeVoting");
        return modelAndView;
    }

    @RequestMapping("/solveTask.do")
    public ModelAndView solveTask() {

        System.out.println("--------solveTask.do----------");


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myTask.do?taskState=solving");
        return modelAndView;
    }


    @RequestMapping("/completeSolveTask.do")
    public ModelAndView completeSolveTask() {

        System.out.println("--------completeSolveTask.do----------");


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myTask.do?taskState=solving");
        return modelAndView;
    }


    @RequestMapping("/solveVoteTask.do")
    public ModelAndView solveVoteTask() {

        System.out.println("--------solveVoteTask.do----------");


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myTask.do?taskState=solveVoting");
        return modelAndView;
    }

    @RequestMapping("/completeSolveVoteTask.do")
    public ModelAndView completeSolveVoteTask() {

        System.out.println("--------completeSolveVoteTask.do----------");


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myTask.do?taskState=solveVoting");
        return modelAndView;
    }



}
