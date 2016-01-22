package com.sysu.crowdsourcing.controllers;


import com.sysu.crowdsourcing.entity.TaskEntity;
import com.sysu.crowdsourcing.services.PostService;
import com.sysu.crowdsourcing.tools.TaskType;
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
    public ModelAndView postTask(@ModelAttribute TaskEntity taskEntity, HttpSession httpSession) {

        System.out.println("--------postTask----------");

        ModelAndView modelAndView = new ModelAndView();

        taskEntity.setTaskType(TaskType.MainTask);
        taskEntity.setTaskReleaseTime(new Date());

        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        taskEntity.setUserEntity(userEntity);

        System.out.printf(taskEntity.toString());


        boolean b = postService.postTask(taskEntity);

        if (b) {
            modelAndView.addObject("sucessMessage", "发布成功");
            modelAndView.setViewName("sucess");
        } else {
            modelAndView.addObject("errorMessage", "发布错误");
            modelAndView.setViewName("error");
        }
        return modelAndView;

    }
}
