package com.sysu.model.crowdsourcing.controllers;

import com.sysu.model.crowdsourcing.services.LoginService;
import com.sysu.workflow.entity.UserEntity;
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
public class LoginController {
    @Resource(name = "loginService")
    LoginService loginService;

    @RequestMapping("/login.do")
    public ModelAndView login(@ModelAttribute UserEntity userEntity, HttpSession httpSession) {

        System.out.println("-------login---------");
        ModelAndView modelAndView = new ModelAndView();

        boolean b = loginService.login(userEntity);
        if (b == true) {
            UserEntity queriedUserEntity = loginService.getUserByEmail(userEntity.getUserEmail());
            httpSession.setAttribute("currentUserEntity", queriedUserEntity);
            if ("admin".equals(queriedUserEntity.getUserRealName())) {
                modelAndView.setViewName("redirect:/manage.do");
            } else if ("poster".equals(queriedUserEntity.getUserRealName())) {
                modelAndView.setViewName("redirect:/myPostedTask.do");
            } else {
                modelAndView.setViewName("redirect:/myTask.do");
            }

        } else {
            modelAndView.addObject("loginError", "�û��������������");
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @RequestMapping("/logout.do")
    public ModelAndView logout(HttpSession httpSession) {

        System.out.println("-------logout---------");
        ModelAndView modelAndView = new ModelAndView();


        httpSession.setAttribute("currentUserEntity", null);
        modelAndView.setViewName("login");

        return modelAndView;
    }


}
