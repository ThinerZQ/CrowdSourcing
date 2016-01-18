package com.sysu.crowdsourcing.controllers;

import com.sysu.crowdsourcing.services.TaskService;
import com.sysu.workflow.service.indentityservice.WorkItemEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
@Controller
public class TaskController {



    @Resource(name = "taskService")
    TaskService taskService;

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
    public ModelAndView myTask() {

        System.out.println("--------myTask.do----------");
        System.out.println("--------load my workitem----------");

        ModelAndView modelAndView = new ModelAndView();
        ArrayList<WorkItemEntity> workItemEntityList = (ArrayList<WorkItemEntity>) taskService.getAllMyWorkItem();

        modelAndView.addObject("workItemEntityList", workItemEntityList);
        modelAndView.setViewName("myTask");
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
