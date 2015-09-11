package com.zhengshouzi.myweb.controllers;


import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.services.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
@Controller
public class PostController {

    @Resource(name = "postService")
    PostService postService;
    @RequestMapping("/post.do")
    public ModelAndView postTask(@ModelAttribute TaskEntity taskEntity) {

        System.out.println("--------post----------");

        ModelAndView modelAndView  = new ModelAndView();

        boolean b = postService.postTask(taskEntity);

        if (b==true){
            modelAndView.setViewName("redirect:/getSystemAllJudgeTask.do");








        }else {

            modelAndView.addObject("errorMessage","·¢²¼´íÎó");
            modelAndView.setViewName("error");
        }
        return modelAndView;

    }
}
