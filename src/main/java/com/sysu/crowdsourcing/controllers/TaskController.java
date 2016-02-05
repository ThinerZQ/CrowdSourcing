package com.sysu.crowdsourcing.controllers;


import com.sysu.crowdsourcing.entity.CrowdSourcingTask;
import com.sysu.crowdsourcing.services.CrowdSourcingTaskService;
import com.sysu.workflow.entity.GroupEntity;
import com.sysu.workflow.entity.GroupWorkItemEntity;
import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.entity.UserWorkItemEntity;
import com.sysu.workflow.service.taskservice.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
/**
 * Created by zhengshouzi on 2015/9/7.
 */
@Controller
public class TaskController {

    @Resource(name = "crowdSourcingTaskService")
    CrowdSourcingTaskService crowdSourcingTaskService;

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
        ArrayList<UserWorkItemEntity> userWorkItemEntityList = TaskService.createUserTaskQuery().taskAssignee(currentUserEntity).list();

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
        UserEntity currentUserEntity = (UserEntity) httpSession.getAttribute("currentUserEntity");

        System.out.println(userWorkItemId);
        TaskService taskService = new TaskService();
        if (userWorkItemId != null) {
            UserWorkItemEntity userWorkItemEntity = taskService.createUserTaskQuery().taskId(Integer.parseInt(userWorkItemId)).SingleResult();
            CrowdSourcingTask crowdSourcingTask = crowdSourcingTaskService.getCrowdSourcingTaskByProcessInstanceId(userWorkItemEntity.getItemProcessInstanceEntity().getId());
            String currentState = userWorkItemEntity.getItemProcessInstanceEntity().getProcessInstanceCurrentState();
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

    @RequestMapping("/decomposeTask.do")
    public ModelAndView solveTask() {

        System.out.println("--------decomposeTask.do----------");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myTask.do?taskState=decomposing");
        return modelAndView;
    }

    @RequestMapping("/decomposeVoteTask.do")
    public ModelAndView mergeTask() {

        System.out.println("--------decomposeVoteTask.do----------");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myTask.do?taskState=decomposeVoting");
        return modelAndView;
    }

    @RequestMapping("/solveTask.do")
    public ModelAndView voteTask() {

        System.out.println("--------solveTask.do----------");


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myTask.do?taskState=solving");
        return modelAndView;
    }

    @RequestMapping("/solveVoteTask.do")
    public ModelAndView decomposeTask() {

        System.out.println("--------solveVoteTask.do----------");


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/myTask.do?taskState=solveVoting");
        return modelAndView;
    }


}
