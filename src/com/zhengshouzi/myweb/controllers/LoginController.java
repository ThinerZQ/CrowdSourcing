package com.zhengshouzi.myweb.controllers;

import com.zhengshouzi.myweb.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.zhengshouzi.myweb.beans.User;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
@Controller
public class LoginController  {
    @Resource(name = "loginService")
    LoginService loginService;

    @RequestMapping("/login.do")
    public ModelAndView login(@ModelAttribute User user,HttpSession httpSession){

        System.out.println("-------login---------");
        ModelAndView modelAndView = new ModelAndView();

        boolean b = loginService.login(user);
        if (b==true){
            user = loginService.getUserByEmail(user.getEmail());
            httpSession.setAttribute("user",user);
            modelAndView.setViewName("redirect:/getSystemAllJudgeTask.do");
        }else{
            modelAndView.addObject("loginError","用户名或者密码错误");
            modelAndView.setViewName("login");
        }

        return  modelAndView;
    }



}
