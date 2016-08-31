package com.sysu.crowdsourcing.controllers;


import com.sysu.crowdsourcing.service.PostService;
import com.sysu.model.crowdsourcing.CrowdSourcingTaskEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
@Controller
public class PostController {

    @Resource
    PostService postService;

    @RequestMapping("/post.do")
    public ModelAndView postTask(@ModelAttribute CrowdSourcingTaskEntity crowdSourcingTaskEntity, HttpSession httpSession) {

        System.out.println("--------postTask----------");

        ModelAndView modelAndView = new ModelAndView();

       /* crowdSourcingTaskEntity.setTaskType(TaskType.MainTask);
        crowdSourcingTaskEntity.setTaskReleaseTime(new Date());

        UserEntity userEntity = (UserEntity) httpSession.getAttribute("currentUserEntity");
        crowdSourcingTaskEntity.setUserEntity(userEntity);
*/
        System.out.printf(crowdSourcingTaskEntity.toString());


        boolean b = postService.postTask(crowdSourcingTaskEntity);

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
