package com.sysu.crowdsourcing.controllers;


import com.sysu.crowdsourcing.exceptions.SCXMLExecuteException;
import com.sysu.crowdsourcing.service.*;
import com.sysu.persistence.model.crowdsourcing.*;
import com.sysu.persistence.model.workflow.*;
import com.sysu.workflow.SCXMLExecutor;
import com.sysu.workflow.SCXMLSystemContext;
import com.sysu.workflow.TriggerEvent;
import com.sysu.workflow.engine.SCXMLInstanceManager;
import com.sysu.workflow.service.processservice.RuntimeService;
import com.sysu.workflow.service.taskservice.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Controller(value = "/task")
public class TaskController {
    private static Logger logger = LoggerFactory.getLogger(TaskController.class);
    @Resource
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


    @RequestMapping("/myTask")
    public ModelAndView myTask(HttpSession httpSession) {

        System.out.println("--------myTask.do----------");
        System.out.println("--------load my workitem----------");

        //TODO: correct below

        ModelAndView modelAndView = new ModelAndView();
        UserEntity currentUserEntity = (UserEntity) httpSession.getAttribute("currentUserEntity");
        ArrayList<UserWorkItemEntity> userWorkItemEntityList = TaskService.createUserTaskQuery().taskAssignee(currentUserEntity).taskFinish(null).list();

        Map<GroupEntity, ArrayList<GroupWorkItemEntity>> groupWorkItemArrayListMap = new LinkedHashMap<GroupEntity, ArrayList<GroupWorkItemEntity>>();

       /* for (GroupEntity groupEntity : currentUserEntity.getGroupEntitySet()) {
            ArrayList<GroupWorkItemEntity> groupWorkItemEntityArrayList = TaskService.createGroupTaskQuery().taskCandidateGroup(groupEntity).list();

            if (groupWorkItemEntityArrayList.size() != 0) {
                groupWorkItemArrayListMap.put(groupEntity, groupWorkItemEntityArrayList);
            }
        }*/

        for (Map.Entry<GroupEntity, ArrayList<GroupWorkItemEntity>> entry : groupWorkItemArrayListMap.entrySet()) {
            GroupEntity groupEntity = entry.getKey();
            ArrayList<GroupWorkItemEntity> groupWorkItemEntityArrayList = entry.getValue();
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

    @RequestMapping("/signIn")
    public ModelAndView signIn(String groupWorkItemId, HttpSession httpSession) {
        System.out.println("--------signIn.do----------");

        ModelAndView modelAndView = new ModelAndView();
        UserEntity currentUserEntity = (UserEntity) httpSession.getAttribute("currentUserEntity");

        System.out.println(groupWorkItemId);
        TaskService taskService = new TaskService();
        if (groupWorkItemId != null) {
            GroupWorkItemEntity groupWorkItemEntity = TaskService.createGroupTaskQuery().taskId(Integer.parseInt(groupWorkItemId)).SingleResult();
            //����group workitem
            int instance;
            instance = groupWorkItemEntity.getItemInstances();
            if (groupWorkItemEntity.getItemInstances() <= 0) {
                //���أ���ʾ�����������ˡ�
                System.out.println("group work done ");
            } else {

                UserWorkItemEntity userWorkItemEntity = taskService.newWorkItem();
                //����user workitem
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
            CrowdSourcingTaskEntity crowdSourcingTaskEntity = crowdSourcingTaskService.getCrowdSourcingTaskByProcessInstanceId(userWorkItemEntity.getItemProcessInstanceEntity().getId());
            String currentState = userWorkItemEntity.getItemProcessInstanceEntity().getProcessInstanceCurrentState();


            if (userWorkItemEntity.getItemName().equals("DecomposeVoteTaskEntity")) {
                ArrayList<UserWorkItemEntity> decomposeTaskUserWorkflowEntity = TaskService.createUserTaskQuery().taskFinish("yes").taskName("DecomposeTaskEntity").taskProcessInstanceId(userWorkItemEntity.getItemProcessId()).list();

                Map<UserWorkItemEntity, ArrayList<DecomposeTaskEntity>> decomposeTaskUserWorkflowMap = new HashMap<UserWorkItemEntity, ArrayList<DecomposeTaskEntity>>();
                //get coorespond decompose result for each userworkflowEntity
                for (UserWorkItemEntity tempEntity : decomposeTaskUserWorkflowEntity) {
                    DecomposeTaskEntity tempDecomposeTaskEntity = new DecomposeTaskEntity();
                    //tempDecomposeTaskEntity.setUserWorkItemEntity(tempEntity);
                    ArrayList<DecomposeTaskEntity> decomposeTaskEntityArrayList = decomposeTaskService.getDecomposeTasks(tempDecomposeTaskEntity);
                    decomposeTaskUserWorkflowMap.put(tempEntity, decomposeTaskEntityArrayList);
                }
                modelAndView.addObject("decomposeTaskUserWorkflowMap", decomposeTaskUserWorkflowMap);
            } else if (userWorkItemEntity.getItemName().equals("SolveVoteTaskEntity")) {
                {
                    ArrayList<UserWorkItemEntity> solveTaskUserWorkflowEntity = TaskService.createUserTaskQuery().taskFinish("yes").taskName("SolveTaskEntity").taskProcessInstanceId(userWorkItemEntity.getItemProcessId()).list();

                    Map<UserWorkItemEntity, SolveTaskEntity> solveTaskUserWorkflowMap = new HashMap<UserWorkItemEntity, SolveTaskEntity>();
                    //get coorespond solve result for each userworkflowEntity
                    for (UserWorkItemEntity tempEntity : solveTaskUserWorkflowEntity) {
                        SolveTaskEntity solveTaskEntity = new SolveTaskEntity();
                        //solveTaskEntity.setUserWorkItemEntity(tempEntity);
                        SolveTaskEntity solveTaskEntity1 = solveTaskService.getSolveTask(solveTaskEntity);
                        solveTaskUserWorkflowMap.put(tempEntity, solveTaskEntity1);
                    }
                    modelAndView.addObject("solveTaskUserWorkflowMap", solveTaskUserWorkflowMap);
                }
            }


            modelAndView.addObject("userWorkItemEntity", userWorkItemEntity);
            modelAndView.addObject("crowdSourcingTask", crowdSourcingTaskEntity);


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
    public ModelAndView completeJudgeTask(@ModelAttribute JudgeTaskEntity judgeTaskEntity, String userWorkItemId, HttpSession httpSession) {

        System.out.println("--------completeJudgeTask.do----------");

        ModelAndView modelAndView = new ModelAndView();

        judgeTaskEntity.setTaskCompleteTime(new Date());
        System.out.println(judgeTaskEntity.toString());
        System.out.println(userWorkItemId);
        UserWorkItemEntity userWorkItemEntity = null;
        try {
            if (userWorkItemId != null) {
                userWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(userWorkItemId)).SingleResult();
                //judgeTaskEntity.setUserWorkItemEntity(userWorkItemEntity);
            }
           /* if (judgeTaskEntity.getUserWorkItemEntity() == null) {
                modelAndView.setViewName("error");
                return modelAndView;
            }*/
            long id = judgeTaskService.saveJudgeTask(judgeTaskEntity);
            //save result sucess ,then update itemFinish to yes
            if (id != -1) {
                userWorkItemEntity.setItemFinish("yes");
                TaskService taskService = new TaskService();
                taskService.updateUserWorkItem(userWorkItemEntity);

                int simple = -1;
                //notify scxml executor
                if ("complex".equals(judgeTaskEntity.getProperty())) {
                    simple = 1;
                } else if ("simple".equals(judgeTaskEntity.getProperty())) {
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

        //д��decomposeVoteTask
        if (userWorkItemId != null && steps != null && (step = Integer.parseInt(steps)) > 0) {
            UserWorkItemEntity userWorkItemEntity = null;
            try {
                userWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(userWorkItemId)).SingleResult();
                if (userWorkItemEntity == null) {
                    modelAndView.setViewName("error");
                    return modelAndView;
                }

                ArrayList<DecomposeTaskEntity> decomposeTaskEntities = new ArrayList<DecomposeTaskEntity>();
                for (int i = 0; i < step; i++) {

                    DecomposeTaskEntity decomposeTaskEntity = new DecomposeTaskEntity();
                    decomposeTaskEntity.setTaskCompleteTime(new Date());

                    String tempOrder = order[i];
                    String tempStepName = stepName[i];
                    String tempStepDescription = stepDescription[i];

                    //decomposeTaskEntity.setUserWorkItemEntity(userWorkItemEntity);
                    decomposeTaskEntity.setTaskName(tempStepName);
                    decomposeTaskEntity.setTaskOrder(tempOrder);
                    decomposeTaskEntity.setTaskDescription(tempStepDescription);

                    decomposeTaskEntities.add(decomposeTaskEntity);
                }

                boolean flag = decomposeTaskService.saveDecomposeTask(decomposeTaskEntities);

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

        //д��decomposeVoteTask
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
                ArrayList<DecomposeTaskEntity> voteDecomposeTaskEntity = new ArrayList<DecomposeTaskEntity>();

                DecomposeTaskEntity tempDecomposeTaskEntity = new DecomposeTaskEntity();
                //tempDecomposeTaskEntity.setUserWorkItemEntity(votedUserWorkItemEntity);
                voteDecomposeTaskEntity = decomposeTaskService.getDecomposeTasks(tempDecomposeTaskEntity);

                //save decomposeVoteTaskEntity
                DecomposeVoteTaskEntity decomposeVoteTaskEntity = new DecomposeVoteTaskEntity();
                decomposeVoteTaskEntity.setTaskCompleteTime(new Date());
                //decomposeVoteTaskEntity.setUserWorkItemEntity(userWorkItemEntity);
                //decomposeVoteTaskEntity.setDecomposeTaskSet(new HashSet<DecomposeTaskEntity>(voteDecomposeTaskEntity));


                // TODO :
                long id = decomposeVoteTaskService.saveDecomposeVoteTask(decomposeVoteTaskEntity);

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
                    CrowdSourcingTaskEntity crowdSourcingTaskEntity = crowdSourcingTaskService.getCrowdSourcingTaskByProcessInstanceId(userWorkItemEntity.getItemProcessInstanceEntity().getId());

                    ArrayList<UserWorkItemEntity> tempUserWorkflowEntitys = TaskService.createUserTaskQuery().taskProcessInstanceId(userWorkItemEntity.getItemProcessId()).taskName("DecomposeVoteTaskEntity").taskFinish("yes").list();
                    int votedCount = tempUserWorkflowEntitys.size();
                    //all people have been voted
                    Map<Integer, Integer> tempMap = new HashMap<Integer, Integer>();
                    if (crowdSourcingTaskEntity.getTaskDecomposeVoteCount() == votedCount) {
                        //get the best decompose result
                        for (UserWorkItemEntity tempUserWorkflowEntity : tempUserWorkflowEntitys) {

                            DecomposeVoteTaskEntity condDecomposeVoteTaskEntity = new DecomposeVoteTaskEntity();
                            //condDecomposeVoteTaskEntity.setUserWorkItemEntity(tempUserWorkflowEntity);

                            DecomposeVoteTaskEntity decomposeVoteTaskEntity1 = decomposeVoteTaskService.getDecomposeVoteTasks(condDecomposeVoteTaskEntity);

                            //get decomposeVoteTaskEntity's vote result
                            /*Set<DecomposeTaskEntity> decomposeTasks = decomposeVoteTaskEntity1.getDecomposeTaskSet();
                            for (DecomposeTaskEntity dt : decomposeTasks) {
                                if (tempMap.get((int) dt.getTaskId()) != null)
                                    tempMap.put((int) dt.getTaskId(), tempMap.get((int) dt.getTaskId()) + 1);
                                else
                                    tempMap.put((int) dt.getTaskId(), 1);
                            }*/
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
                        Set<DecomposeTaskEntity> bestDecomposeTaskEntities = new HashSet<DecomposeTaskEntity>();
                        for (int index : bestIndexs) {
                            DecomposeTaskEntity condDt = new DecomposeTaskEntity();
                            condDt.setTaskId(index);
                            DecomposeTaskEntity dt_1 = decomposeTaskService.getDecomposeTask(condDt);
                            bestDecomposeTaskEntities.add(dt_1);
                        }

                        //write to crowdsoucing table
                        if (bestDecomposeTaskEntities != null && bestDecomposeTaskEntities.size() != 0) {
                            Set<CrowdSourcingTaskEntity> crowdSourcingTaskEntityArrayList = new HashSet<CrowdSourcingTaskEntity>();
                            for (DecomposeTaskEntity tempDecomposeTaskEntity1 : bestDecomposeTaskEntities) {

                                CrowdSourcingTaskEntity tempCrowdSourcingTaskEntity = new CrowdSourcingTaskEntity();

                                tempCrowdSourcingTaskEntity.setTaskName(tempDecomposeTaskEntity1.getTaskName());
                                tempCrowdSourcingTaskEntity.setTaskDescription(tempDecomposeTaskEntity1.getTaskDescription());
                                tempCrowdSourcingTaskEntity.setTaskStep(Integer.valueOf(tempDecomposeTaskEntity1.getTaskOrder()));
                                //tempCrowdSourcingTaskEntity.setTaskReleaseTime(new Date());
                                //tempCrowdSourcingTaskEntity.setUserEntity(userWorkItemEntity.getItemAssigneeEntity());

                                crowdSourcingTaskEntityArrayList.add(tempCrowdSourcingTaskEntity);

                                //update best decomposeTask property "best" to yes
                                tempDecomposeTaskEntity1.setTaskBest("yes");
                                decomposeTaskService.updateDecomposeTask(tempDecomposeTaskEntity1);
                            }
                            //postService.saveCrowdSourcingTask(crowdSourcingTaskEntityArrayList);

                            //update current crowdsourcingTask's subCrowdSourcingTask record
                            //crowdSourcingTaskEntity.setTaskSubCrowdSourcingTask(crowdSourcingTaskEntityArrayList);
                            crowdSourcingTaskService.updateCrowdSourcingTask(crowdSourcingTaskEntity);


                            crowdSourcingTaskEntity = crowdSourcingTaskService.getCrowdSourcingTaskByProcessInstanceId(userWorkItemEntity.getItemProcessInstanceEntity().getId());
                            //crowdSourcingTaskEntityArrayList = crowdSourcingTaskEntity.getTaskSubCrowdSourcingTask();

                            executor.getRootContext().set("crowdSourcingTaskEntityArrayList", crowdSourcingTaskEntityArrayList);
                            executor.getRootContext().set("crowdSourcingTaskEntity", crowdSourcingTaskEntity);
                            executor.triggerEvent(new TriggerEvent("startSubMachine", TriggerEvent.SIGNAL_EVENT));


                            //record the bestCrowdSourcingTask correspond processInstance Id .

                            CrowdSourcingTaskEntity rootContextCrowdSourcingTaskEntity = (CrowdSourcingTaskEntity) executor.getRootContext().get("crowdSourcingTaskEntity");
                            ArrayList<String> childSessionIdList = executor.getSCXMLInstanceTree().getChildTreeNodeSessionId((String) executor.getGlobalContext().getSystemContext().get(SCXMLSystemContext.SESSIONID_KEY));

                            for (String sessionId : childSessionIdList) {
                                SCXMLExecutor childSCXMLExecutor = SCXMLInstanceManager.getSCXMLInstanceExecutor(sessionId);
                                CrowdSourcingTaskEntity tempRootContextCrowdSourcingTaskEntity = (CrowdSourcingTaskEntity) childSCXMLExecutor.getRootContext().get("crowdSourcingTaskEntity");

                                //according the tempRootContextCrowdSourcingTaskEntity 's ID update it's processInstance ,
                                //TODO : this tempRootContextCrowdSourcingTaskEntity no task id , so look pre and solve it

                                ProcessInstanceEntity childProcessInstanceEntity = RuntimeService.createProcessInstanceQuery().processInstanceId(sessionId).SingleResult();

                                //tempRootContextCrowdSourcingTaskEntity.setProcessInstanceEntity(childProcessInstanceEntity);

                                crowdSourcingTaskService.updateCrowdSourcingTask(tempRootContextCrowdSourcingTaskEntity);
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
    public ModelAndView completeSolveTask(@ModelAttribute SolveTaskEntity solveTaskEntity, String userWorkItemId, HttpSession httpSession) {

        System.out.println("--------completeSolveTask.do----------");


        ModelAndView modelAndView = new ModelAndView();

        solveTaskEntity.setTaskCompleteTime(new Date());
        System.out.println(solveTaskEntity.toString());
        System.out.println(userWorkItemId);
        UserWorkItemEntity userWorkItemEntity = null;
        try {
            if (userWorkItemId != null) {
                userWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(userWorkItemId)).SingleResult();
                //solveTaskEntity.setUserWorkItemEntity(userWorkItemEntity);
            }
           /* if (solveTaskEntity.getUserWorkItemEntity() == null) {
                modelAndView.setViewName("error");
                return modelAndView;
            }*/
            long id = solveTaskService.saveSolveVote(solveTaskEntity);
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


        //д��solveVoteTask
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


                SolveTaskEntity tempSolveTaskEntity = new SolveTaskEntity();
                //tempSolveTaskEntity.setUserWorkItemEntity(votedUserWorkItemEntity);
                tempSolveTaskEntity = solveTaskService.getSolveTask(tempSolveTaskEntity);

                //save solveVoteTaskEntity
                SolveVoteTaskEntity solveVoteTaskEntity = new SolveVoteTaskEntity();
                /*solveVoteTaskEntity.setTaskCompleteTime(new Date());
                solveVoteTaskEntity.setUserWorkItemEntity(userWorkItemEntity);
                solveVoteTaskEntity.setSolveTask(tempSolveTaskEntity);*/


                // TODO :
                long id = solveVoteTaskService.saveSolveVoteTask(solveVoteTaskEntity);

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
                    CrowdSourcingTaskEntity crowdSourcingTaskEntity = crowdSourcingTaskService.getCrowdSourcingTaskByProcessInstanceId(userWorkItemEntity.getItemProcessInstanceEntity().getId());

                    ArrayList<UserWorkItemEntity> tempUserWorkflowEntitys = TaskService.createUserTaskQuery().taskProcessInstanceId(userWorkItemEntity.getItemProcessId()).taskName("SolveVoteTaskEntity").taskFinish("yes").list();
                    int votedCount = tempUserWorkflowEntitys.size();
                    //all people have been voted
                    Map<Long, Long> tempMap = new HashMap<Long, Long>();
                    if (crowdSourcingTaskEntity.getTaskSolveVoteCount() == votedCount) {
                        //get the best solve result
                        for (UserWorkItemEntity tempUserWorkflowEntity : tempUserWorkflowEntitys) {

                            SolveVoteTaskEntity condSolveVoteTaskEntity = new SolveVoteTaskEntity();
                            //condSolveVoteTaskEntity.setUserWorkItemEntity(tempUserWorkflowEntity);

                            SolveVoteTaskEntity solveVoteTaskEntity1 = solveVoteTaskService.getSolveVoteTask(condSolveVoteTaskEntity);
                            /*long taskId = solveVoteTaskEntity1.getSolveTask().getTaskId();
                            if (tempMap.containsKey(taskId)) {
                                tempMap.put(taskId, tempMap.get(taskId) + 1);
                            } else {
                                tempMap.put(taskId, (long) 1);
                            }*/
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
                        SolveTaskEntity task1 = new SolveTaskEntity();
                        task1.setTaskId(maxIndex);
                        SolveTaskEntity sessionSolveTaskEntity = solveTaskService.getSolveTask(task1);
                        sessionSolveTaskEntity.setTaskBest("yes");
                        solveTaskService.updateSolveTask(sessionSolveTaskEntity);
                        crowdSourcingTaskEntity.setTaskSolution(sessionSolveTaskEntity.getTaskSolution());
                        //cory bestSolution to crowdsourcingTask if this crowdsourcing task is simple
                        crowdSourcingTaskService.updateCrowdSourcingTask(crowdSourcingTaskEntity);
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

        CrowdSourcingTaskEntity condCrowdSourcingTaskEntity = new CrowdSourcingTaskEntity();
        //condCrowdSourcingTaskEntity.setUserEntity((UserEntity) httpSession.getAttribute("currentUserEntity"));

        List<CrowdSourcingTaskEntity> myPostedCrowdSourcingTaskEntityList = crowdSourcingTaskService.getCrowdSourcingTask(condCrowdSourcingTaskEntity);

        modelAndView.addObject("myPostedCrowdSourcingTaskList", myPostedCrowdSourcingTaskEntityList);

        modelAndView.setViewName("postTask");

        return modelAndView;

    }

    @RequestMapping("/myPostedTaskDetail")
    public ModelAndView myPostedTaskDetail(String taskId) {

        System.out.println("--------myPostedTaskDetail.do----------");

        ModelAndView modelAndView = new ModelAndView();

        CrowdSourcingTaskEntity condCrowdSourcingTaskEntity = new CrowdSourcingTaskEntity();
        condCrowdSourcingTaskEntity.setTaskId(Integer.parseInt(taskId));

        List<CrowdSourcingTaskEntity> myPostedCrowdSourcingTaskEntityList = crowdSourcingTaskService.getCrowdSourcingTask(condCrowdSourcingTaskEntity);

        modelAndView.addObject("myPostedCrowdSourcingTask", myPostedCrowdSourcingTaskEntityList.get(0));

        modelAndView.setViewName("postedTaskDetail");

        return modelAndView;

    }

}
