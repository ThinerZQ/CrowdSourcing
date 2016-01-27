package com.sysu.crowdsourcing.controllers;


import com.sysu.workflow.entity.GroupEntity;
import com.sysu.workflow.entity.GroupWorkItemEntity;
import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.entity.UserWorkItemEntity;
import com.sysu.workflow.service.taskservice.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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



    /*@Resource(name = "taskService")
    TaskService taskService;*/

    @RequestMapping("/Home.do")
    public ModelAndView Home() {

        System.out.println("--------Home----------");

        ModelAndView modelAndView = new ModelAndView();
     /*   List<TaskEntity> taskEntityList = taskService.getAllTask();
        modelAndView.addObject("HomeTaskEntityList", taskEntityList);*/
        modelAndView.setViewName("index");
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

        if (groupWorkItemId != null) {
            GroupWorkItemEntity groupWorkItemEntity = TaskService.createGroupTaskQuery().taskId(Integer.parseInt(groupWorkItemId)).SingleResult();
            //更新group workitem
            int instance;
            instance = groupWorkItemEntity.getItemInstances();
            if (groupWorkItemEntity.getItemInstances() <= 0) {
                //返回，提示组任务被做完了。
                System.out.println("group work done ");
            } else {
                TaskService taskService = new TaskService();
                UserWorkItemEntity userWorkItemEntity = taskService.newWorkItem();
                //保存user workitem
                userWorkItemEntity.setItemName(groupWorkItemEntity.getItemName())
                        .setItemCreateTime(new Date().toLocaleString())
                        .setItemStateId(groupWorkItemEntity.getItemStateId())
                        .setItemProcessId(groupWorkItemEntity.getItemProcessId())
                        .setItemAssigneeEntity(currentUserEntity);
                //.setItemFormEntity(groupWorkItemEntity.getItemFormEntity());
                // .setItemGroupWorkItemEntity(groupWorkItemEntity);
                taskService.saveUserWorkItem(userWorkItemEntity);

                instance = groupWorkItemEntity.getItemInstances() - 1;
                groupWorkItemEntity.setItemInstances(instance);
                taskService.updateGroupWorkItem(groupWorkItemEntity);
                modelAndView.setViewName("redirect:/myTask.do");
            }
        }
        return modelAndView;
    }

    @RequestMapping("/taskDetail.do")
    public ModelAndView taskDetail(String taskWorkItemId, HttpSession httpSession) {
        System.out.println("--------taskDetail.do----------");

        ModelAndView modelAndView = new ModelAndView();
        UserEntity currentUserEntity = (UserEntity) httpSession.getAttribute("currentUserEntity");

        System.out.println(taskWorkItemId);

        if (taskWorkItemId != null) {
            UserWorkItemEntity userWorkItemEntity = TaskService.createUserTaskQuery().taskId(Integer.parseInt(taskWorkItemId)).SingleResult();
            modelAndView.addObject("userWorkItemEntity", userWorkItemEntity);
            modelAndView.setViewName("taskDetail");
        }

        return modelAndView;
    }

    @RequestMapping("/task.do")
    public ModelAndView task() {

        System.out.println("--------task.do----------");

        ModelAndView modelAndView = new ModelAndView();
       /* List<TaskEntity> taskEntityList = taskService.getAllTask();
        modelAndView.addObject("taskEntityList", taskEntityList);*/
        modelAndView.setViewName("task");
        return modelAndView;
    }

    @RequestMapping("/judgeTask.do")
    public ModelAndView judgeTask() {

        System.out.println("--------judgeTask.do----------");

        ModelAndView modelAndView = new ModelAndView();
       /* List<JudgetaskEntity> judgetaskEntityList = judgeTaskService.getAllJudgeTask();
        modelAndView.addObject("judgetaskEntityList", judgetaskEntityList);
        modelAndView.setViewName("judgeTask");*/
        return modelAndView;
    }

    @RequestMapping("/solveTask.do")
    public ModelAndView solveTask() {

        System.out.println("--------solveTask.do----------");

        ModelAndView modelAndView = new ModelAndView();
      /*  List<SolvetaskEntity> solvetaskEntityList = solveTaskService.getAllSolveTask();
        modelAndView.addObject("solvetaskEntityList", solvetaskEntityList);
        modelAndView.setViewName("solveTask");*/
        return modelAndView;
    }

    @RequestMapping("/mergeTask.do")
    public ModelAndView mergeTask() {

        System.out.println("--------mergeTask.do----------");

        ModelAndView modelAndView = new ModelAndView();
      /*  List<MergetaskEntity> mergetaskEntityList = mergeTaskService.getAllMergeTask();
        modelAndView.addObject("mergetaskEntityList", mergetaskEntityList);
        modelAndView.setViewName("mergeTask");*/
        return modelAndView;
    }

    @RequestMapping("/voteTask.do")
    public ModelAndView voteTask() {

        System.out.println("--------voteTask.do----------");

        ModelAndView modelAndView = new ModelAndView();
     /*   List<VotetaskEntity> votetaskEntityList = voteTaskService.getAllVoteTask();
        modelAndView.addObject("votetaskEntityList", votetaskEntityList);
        modelAndView.setViewName("voteTask");*/
        return modelAndView;
    }

    @RequestMapping("/decomposeTask.do")
    public ModelAndView decomposeTask() {

        System.out.println("--------decomposeTask.do----------");

        ModelAndView modelAndView = new ModelAndView();
      /*  List<DecomposetaskEntity> decomposetaskEntityList = decomposeTaskService.getAllDecomposeTask();
        modelAndView.addObject("decomposetaskEntityList", decomposetaskEntityList);
        modelAndView.setViewName("decomposeTask");*/
        return modelAndView;
    }


}
