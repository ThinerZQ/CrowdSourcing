package com.sysu.crowdsourcing.controllers;


import com.sysu.crowdsourcing.entity.TaskEntity;
import com.sysu.crowdsourcing.entity.UserEntity;
import com.sysu.crowdsourcing.services.PostService;
import com.sysu.crowdsourcing.tools.TaskType;
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

        System.out.println("--------post----------");

        ModelAndView modelAndView = new ModelAndView();

        taskEntity.setTaskType(TaskType.MainTask);
        taskEntity.setReleaseTime(new Date());

        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        taskEntity.setUserEntity(userEntity);


        System.out.println(taskEntity.getDeadlineTime());
        System.out.println(taskEntity.getTitle());
        System.out.println(taskEntity.getDescriptionEntitySet().size());

        //System.out.printf(taskEntity.toString());


        boolean b = postService.postTask(taskEntity);

        if (b) {
            modelAndView.setViewName("redirect:/getSystemAllJudgeTask.do");
        } else {

            modelAndView.addObject("errorMessage", "·¢²¼´íÎó");
            modelAndView.setViewName("error");
        }
        return modelAndView;

    }
}
