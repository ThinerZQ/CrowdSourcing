package com.zhengshouzi.myweb.controllers;


import com.zhengshouzi.myweb.forms.TaskForm;
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
    public ModelAndView postTask(@ModelAttribute("taskForm") TaskForm taskForm) {

        System.out.println("--------post----------");

        ModelAndView modelAndView = new ModelAndView();

        System.out.println(taskForm.getDeadlineTime());
        System.out.println(taskForm.getTitle());
        System.out.println(taskForm.getDescription());


        //boolean b = postService.postTask(taskEntity);

        if (true) {
            modelAndView.setViewName("redirect:/getSystemAllJudgeTask.do");
        } else {

            modelAndView.addObject("errorMessage", "·¢²¼´íÎó");
            modelAndView.setViewName("error");
        }
        return modelAndView;

    }
}
