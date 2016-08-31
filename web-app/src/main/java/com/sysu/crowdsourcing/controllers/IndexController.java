package com.sysu.crowdsourcing.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/8/31
 * Time: 10:32
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class IndexController {


    @RequestMapping("/")
    public ModelAndView Index() {

        System.out.println("--------Home----------");

        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }

    @RequestMapping("/home")
    public ModelAndView Home() {

        System.out.println("--------Home----------");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("redirect:/task/myTask");
        return modelAndView;
    }
}
