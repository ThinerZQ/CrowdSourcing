package com.zhengshouzi.myweb.controllers;


import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.entity.UserEntity;
import com.zhengshouzi.myweb.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
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

        System.out.println(taskEntity.getDeadlineTime());
        System.out.println(taskEntity.getTitle());
        System.out.println(taskEntity.getDescriptionEntitySet().size());

        taskEntity.setTaskType("mainTask");
        taskEntity.setReleaseTime(new Timestamp(new Date().getTime()));
        UserEntity userEntity = (UserEntity) httpSession.getAttribute("user");
        taskEntity.setUserEntity(userEntity);

        System.out.printf(taskEntity.toString());


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
