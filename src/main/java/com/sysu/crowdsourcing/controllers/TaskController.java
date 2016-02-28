package com.sysu.crowdsourcing.controllers;


import com.sysu.crowdsourcing.entity.*;
import com.sysu.crowdsourcing.exceptions.SCXMLExecuteException;
import com.sysu.crowdsourcing.services.*;
import com.sysu.workflow.SCXMLExecutor;
import com.sysu.workflow.SCXMLSystemContext;
import com.sysu.workflow.TriggerEvent;
import com.sysu.workflow.engine.SCXMLInstanceManager;
import com.sysu.workflow.entity.*;
import com.sysu.workflow.service.processservice.RuntimeService;
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

    @Resource(name = "postService")
    PostService postService;

    @Resource(name = "solveTaskService")
    SolveTaskService solveTaskService;

    @Resource(name = "solveVoteTaskService")
    SolveVoteTaskService solveVoteTaskService;

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

        //TODO: correct below

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
        }

        //剔除包含在用户任务列表里面的任务
        for (Map.Entry<GroupEntity, ArrayList<GroupWorkItemEntity>> entry : groupWorkItemArrayListMap.entrySet()) {
            GroupEntity groupEntity = entry.getKey();
            ArrayList<GroupWorkItemEntity> groupWorkItemEntityArrayList = entry.getValue();
            //剔除包含在用户任务列表里面的任务
            for (UserWorkItemEntity uwie : userWorkItemEntityList) {


                int size = groupWorkItemEntityArrayList.size();
                // indicate have been signed in
                if (uwie.getItemGroupWorkItemEntity() != null) {
                    Iterator<GroupWorkItemEntity> itemEntityIterator = groupWorkItemEntityArrayList.listIterator();
                    while (itemEntityIterator.hasNext()) {
                        GroupWorkItemEntity gwie = itemEntityIterator.next();
                        if (gwie.getItemId() == uwie.getItemGroupWorkItemEntity().getItemId()) {
                            itemEntityIterator.remove();
                        }
                    }
                }

            }
        }
        Iterator<UserWorkItemEntity> itemEntityIterator = userWorkItemEntityList.listIterator();
        while (itemEntityIterator.hasNext()) {
            UserWorkItemEntity userWorkItemEntity = itemEntityIterator.next();
            if ("yes".equals(userWorkItemEntity.getItemFinish())) {
                itemEntityIterator.remove();
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
            } else if (userWorkItemEntity.getItemName().equals("SolveVoteTask")) {
                {
                    ArrayList<UserWorkItemEntity> solveTaskUserWorkflowEntity = TaskService.createUserTaskQuery().taskFinish("yes").taskName("SolveTask").taskProcessInstanceId(userWorkItemEntity.getItemProcessId()).list();

                    Map<UserWorkItemEntity, SolveTask> solveTaskUserWorkflowMap = new HashMap<UserWorkItemEntity, SolveTask>();
                    //get coorespond solve result for each userworkflowEntity
                    for (UserWorkItemEntity tempEntity : solveTaskUserWorkflowEntity) {
                        SolveTask solveTask = new SolveTask();
                        solveTask.setUserWorkItemEntity(tempEntity);
                        SolveTask solveTask1 = solveTaskService.getSolveTask(solveTask);
                        solveTaskUserWorkflowMap.put(tempEntity, solveTask1);
                    }
                    modelAndView.addObject("solveTaskUserWorkflowMap", solveTaskUserWorkflowMap);
                }
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
                for (int i = 0; i < step; i++) {

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
                votedUserWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(votedUserWorkItemId)).taskFinish("yes").SingleResult();

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


                    executor.triggerEvent(new TriggerEvent("decomposeVoteComplete", TriggerEvent.SIGNAL_EVENT));

                    //get the best decompose result
                    CrowdSourcingTask crowdSourcingTask = crowdSourcingTaskService.getCrowdSourcingTaskByProcessInstanceId(userWorkItemEntity.getItemProcessInstanceEntity().getId());

                    ArrayList<UserWorkItemEntity> tempUserWorkflowEntitys = TaskService.createUserTaskQuery().taskProcessInstanceId(userWorkItemEntity.getItemProcessId()).taskName("DecomposeVoteTask").taskFinish("yes").list();
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
                                if (tempMap.get((int) dt.getTaskId()) != null)
                                    tempMap.put((int) dt.getTaskId(), tempMap.get((int) dt.getTaskId()) + 1);
                                else
                                    tempMap.put((int) dt.getTaskId(), 1);
                            }
                        }

                        int max = 0;
                        for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
                            if (max < entry.getValue()) {
                                max = entry.getValue();
                            }
                        }
                        ArrayList<Integer> bestIndexs = new ArrayList<Integer>();
                        for (Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
                            if (max == entry.getValue()) {
                                bestIndexs.add(entry.getKey());
                            }
                        }
                        Set<DecomposeTask> bestDecomposeTasks = new HashSet<DecomposeTask>();
                        for (int index : bestIndexs) {
                            DecomposeTask condDt = new DecomposeTask();
                            condDt.setTaskId(index);
                            DecomposeTask dt_1 = decomposeTaskService.getDecomposeTask(condDt);
                            bestDecomposeTasks.add(dt_1);
                        }

                        //write to crowdsoucing table
                        if (bestDecomposeTasks != null && bestDecomposeTasks.size() != 0) {
                            Set<CrowdSourcingTask> crowdSourcingTaskArrayList = new HashSet<CrowdSourcingTask>();
                            for (DecomposeTask tempDecomposeTask1 : bestDecomposeTasks) {

                                CrowdSourcingTask tempCrowdSourcingTask = new CrowdSourcingTask();

                                tempCrowdSourcingTask.setTaskName(tempDecomposeTask1.getTaskName());
                                tempCrowdSourcingTask.setTaskDescription(tempDecomposeTask1.getTaskDescription());
                                tempCrowdSourcingTask.setTaskStep(Integer.valueOf(tempDecomposeTask1.getTaskOrder()));
                                tempCrowdSourcingTask.setTaskReleaseTime(new Date());
                                tempCrowdSourcingTask.setUserEntity(userWorkItemEntity.getItemAssigneeEntity());

                                crowdSourcingTaskArrayList.add(tempCrowdSourcingTask);

                                //update best decomposeTask property "best" to yes
                                tempDecomposeTask1.setTaskBest("yes");
                                decomposeTaskService.updateDecomposeTask(tempDecomposeTask1);
                            }
                            //postService.saveCrowdSourcingTask(crowdSourcingTaskArrayList);

                            //update current crowdsourcingTask's subCrowdSourcingTask record
                            crowdSourcingTask.setTaskSubCrowdSourcingTask(crowdSourcingTaskArrayList);
                            crowdSourcingTaskService.updateCrowdSourcingTask(crowdSourcingTask);


                            crowdSourcingTask = crowdSourcingTaskService.getCrowdSourcingTaskByProcessInstanceId(userWorkItemEntity.getItemProcessInstanceEntity().getId());
                            crowdSourcingTaskArrayList = crowdSourcingTask.getTaskSubCrowdSourcingTask();

                            executor.getRootContext().set("crowdSourcingTaskArrayList", crowdSourcingTaskArrayList);
                            executor.getRootContext().set("crowdSourcingTask", crowdSourcingTask);
                            executor.triggerEvent(new TriggerEvent("startSubMachine", TriggerEvent.SIGNAL_EVENT));


                            //record the bestCrowdSourcingTask correspond processInstance Id .

                            CrowdSourcingTask rootContextCrowdSourcingTask = (CrowdSourcingTask) executor.getRootContext().get("crowdSourcingTask");
                            ArrayList<String> childSessionIdList = executor.getSCXMLInstanceTree().getChildTreeNodeSessionId((String) executor.getGlobalContext().getSystemContext().get(SCXMLSystemContext.SESSIONID_KEY));

                            for (String sessionId : childSessionIdList) {
                                SCXMLExecutor childSCXMLExecutor = SCXMLInstanceManager.getSCXMLInstanceExecutor(sessionId);
                                CrowdSourcingTask tempRootContextCrowdSourcingTask = (CrowdSourcingTask) childSCXMLExecutor.getRootContext().get("crowdSourcingTask");

                                //according the tempRootContextCrowdSourcingTask 's ID update it's processInstance ,
                                //TODO : this tempRootContextCrowdSourcingTask no task id , so look pre and solve it

                                ProcessInstanceEntity childProcessInstanceEntity = RuntimeService.createProcessInstanceQuery().processInstanceId(sessionId).SingleResult();

                                tempRootContextCrowdSourcingTask.setProcessInstanceEntity(childProcessInstanceEntity);

                                crowdSourcingTaskService.updateCrowdSourcingTask(tempRootContextCrowdSourcingTask);
                            }

                        }
                    }
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
    public ModelAndView completeSolveTask(@ModelAttribute SolveTask solveTask, String userWorkItemId, HttpSession httpSession) {

        System.out.println("--------completeSolveTask.do----------");


        ModelAndView modelAndView = new ModelAndView();

        solveTask.setTaskCompleteTime(new Date());
        System.out.println(solveTask.toString());
        System.out.println(userWorkItemId);
        UserWorkItemEntity userWorkItemEntity = null;
        try {
            if (userWorkItemId != null) {
                userWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(userWorkItemId)).SingleResult();
                solveTask.setUserWorkItemEntity(userWorkItemEntity);
            }
            if (solveTask.getUserWorkItemEntity() == null) {
                modelAndView.setViewName("error");
                return modelAndView;
            }
            long id = solveTaskService.saveSolveVote(solveTask);
            //save result sucess ,then update itemFinish to yes
            if (id != -1) {
                userWorkItemEntity.setItemFinish("yes");
                TaskService taskService = new TaskService();
                taskService.updateUserWorkItem(userWorkItemEntity);


                SCXMLExecutor executor = SCXMLInstanceManager.getSCXMLInstanceExecutor(userWorkItemEntity.getItemProcessId());
                if (executor == null) {
                    throw new SCXMLExecuteException("no executor exception");
                }
                executor.triggerEvent(new TriggerEvent("solveComplete", TriggerEvent.SIGNAL_EVENT));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.setViewName("redirect:/myTask.do?taskState=judging");
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
    public ModelAndView completeSolveVoteTask(String userWorkItemId, String votedUserWorkItemId) {

        System.out.println("--------completeSolveVoteTask.do----------");

        ModelAndView modelAndView = new ModelAndView();


        //写入solveVoteTask
        if (userWorkItemId != null && votedUserWorkItemId != null) {
            UserWorkItemEntity userWorkItemEntity = null;
            UserWorkItemEntity votedUserWorkItemEntity = null;
            try {
                userWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(userWorkItemId)).SingleResult();
                votedUserWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(votedUserWorkItemId)).taskFinish("yes").SingleResult();

                if (userWorkItemEntity == null || votedUserWorkItemEntity == null) {
                    modelAndView.setViewName("error");
                    return modelAndView;
                }


                SolveTask tempSolveTask = new SolveTask();
                tempSolveTask.setUserWorkItemEntity(votedUserWorkItemEntity);
                tempSolveTask = solveTaskService.getSolveTask(tempSolveTask);

                //save solveVoteTask
                SolveVoteTask solveVoteTask = new SolveVoteTask();
                solveVoteTask.setTaskCompleteTime(new Date());
                solveVoteTask.setUserWorkItemEntity(userWorkItemEntity);
                solveVoteTask.setSolveTask(tempSolveTask);


                // TODO :
                long id = solveVoteTaskService.saveSolveVoteTask(solveVoteTask);

                //save result sucess ,then update itemFinish to yes
                if (id != -1) {
                    userWorkItemEntity.setItemFinish("yes");
                    TaskService taskService = new TaskService();
                    taskService.updateUserWorkItem(userWorkItemEntity);

                    SCXMLExecutor executor = SCXMLInstanceManager.getSCXMLInstanceExecutor(userWorkItemEntity.getItemProcessId());
                    if (executor == null) {
                        throw new SCXMLExecuteException("no  executor exception");
                    }


                    //get the best solve result
                    CrowdSourcingTask crowdSourcingTask = crowdSourcingTaskService.getCrowdSourcingTaskByProcessInstanceId(userWorkItemEntity.getItemProcessInstanceEntity().getId());

                    ArrayList<UserWorkItemEntity> tempUserWorkflowEntitys = TaskService.createUserTaskQuery().taskProcessInstanceId(userWorkItemEntity.getItemProcessId()).taskName("SolveVoteTask").taskFinish("yes").list();
                    int votedCount = tempUserWorkflowEntitys.size();
                    //all people have been voted
                    Map<Long, Long> tempMap = new HashMap<Long, Long>();
                    if (crowdSourcingTask.getTaskSolveVoteCount() == votedCount) {
                        //get the best solve result
                        for (UserWorkItemEntity tempUserWorkflowEntity : tempUserWorkflowEntitys) {

                            SolveVoteTask condSolveVoteTask = new SolveVoteTask();
                            condSolveVoteTask.setUserWorkItemEntity(tempUserWorkflowEntity);

                            SolveVoteTask solveVoteTask1 = solveVoteTaskService.getSolveVoteTask(condSolveVoteTask);
                            long taskId = solveVoteTask1.getSolveTask().getTaskId();
                            if (tempMap.containsKey(taskId)) {
                                tempMap.put(taskId, tempMap.get(taskId) + 1);
                            } else {
                                tempMap.put(taskId, (long) 1);
                            }
                        }
                        // find the most frequence  ,as to bestVoted
                        long maxValue = 0;
                        long maxIndex = 0;
                        for (Map.Entry<Long, Long> entry : tempMap.entrySet()) {
                            if (maxValue < entry.getValue()) {
                                maxValue = entry.getValue();
                                maxIndex = entry.getKey();
                            }
                        }
                        SolveTask task1 = new SolveTask();
                        task1.setTaskId(maxIndex);
                        SolveTask sessionSolveTask = solveTaskService.getSolveTask(task1);
                        sessionSolveTask.setTaskBest("yes");
                        solveTaskService.updateSolveTask(sessionSolveTask);
                        crowdSourcingTask.setTaskSolution(sessionSolveTask.getTaskSolution());
                        //cory bestSolution to crowdsourcingTask if this crowdsourcing task is simple
                        crowdSourcingTaskService.updateCrowdSourcingTask(crowdSourcingTask);
                    }

                    executor.triggerEvent(new TriggerEvent("solveVoteComplete", TriggerEvent.SIGNAL_EVENT));


                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        modelAndView.setViewName("redirect:/myTask.do?taskState=solveVoting");
        return modelAndView;
    }


    @RequestMapping("/myPostedTask.do")
    public ModelAndView myPostedTask(HttpSession httpSession) {

        System.out.println("--------myPostedTask.do----------");

        ModelAndView modelAndView = new ModelAndView();

        CrowdSourcingTask condCrowdSourcingTask = new CrowdSourcingTask();
        condCrowdSourcingTask.setUserEntity((UserEntity) httpSession.getAttribute("currentUserEntity"));

        List<CrowdSourcingTask> myPostedCrowdSourcingTaskList = crowdSourcingTaskService.getCrowdSourcingTask(condCrowdSourcingTask);

        modelAndView.addObject("myPostedCrowdSourcingTaskList", myPostedCrowdSourcingTaskList);

        modelAndView.setViewName("postTask");

        return modelAndView;

    }

    @RequestMapping("/myPostedTaskDetail.do")
    public ModelAndView myPostedTaskDetail(String taskId) {

        System.out.println("--------myPostedTaskDetail.do----------");

        ModelAndView modelAndView = new ModelAndView();

        CrowdSourcingTask condCrowdSourcingTask = new CrowdSourcingTask();
        condCrowdSourcingTask.setTaskId(Integer.parseInt(taskId));

        List<CrowdSourcingTask> myPostedCrowdSourcingTaskList = crowdSourcingTaskService.getCrowdSourcingTask(condCrowdSourcingTask);

        modelAndView.addObject("myPostedCrowdSourcingTask", myPostedCrowdSourcingTaskList.get(0));

        modelAndView.setViewName("postedTaskDetail");

        return modelAndView;

    }

}
