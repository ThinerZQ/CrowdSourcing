package com.sysu.model.crowdsourcing.controllers;


import com.sysu.model.crowdsourcing.entity.CrowdSourcingTask;
import com.sysu.model.crowdsourcing.services.PostService;
import com.sysu.model.crowdsourcing.tools.TaskType;
import com.sysu.workflow.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
@Controller
public class PostController {

    @Resource(name = "postService")
    PostService postService;

    @RequestMapping("/post.do")
    public ModelAndView postTask(@ModelAttribute CrowdSourcingTask crowdSourcingTask, HttpSession httpSession) {

        System.out.println("--------postTask----------");

        ModelAndView modelAndView = new ModelAndView();

        crowdSourcingTask.setTaskType(TaskType.MainTask);
        crowdSourcingTask.setTaskReleaseTime(new Date());

        UserEntity userEntity = (UserEntity) httpSession.getAttribute("currentUserEntity");
        crowdSourcingTask.setUserEntity(userEntity);

        System.out.printf(crowdSourcingTask.toString());


        boolean b = postService.postTask(crowdSourcingTask);

        if (b) {
            modelAndView.addObject("sucessMessage", "Post Success");
            modelAndView.setViewName("sucess");
        } else {
            modelAndView.addObject("errorMessage", "Post Error");
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
