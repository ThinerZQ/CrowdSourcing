package com.zhengshouzi.myweb.controllers;

import com.zhengshouzi.myweb.exceptions.ServiceException;
import com.zhengshouzi.myweb.forms.RegisterForm;
import com.zhengshouzi.myweb.services.RegisterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhengshouzi on 2015/8/23.
 */

@Controller
public class RegisterController {


    @Resource(name = "registerService")
    public RegisterService registerService;


    @ModelAttribute("registerForm")
    public RegisterForm initRegisterForm() {
        RegisterForm registerForm = new RegisterForm();
        return registerForm;
    }

    @RequestMapping("/register/register.do")
    public String proccessRegister(@ModelAttribute RegisterForm registerForm) {

        String returnString = null;
        System.out.print(registerForm.getEmail());
        System.out.println("------------------");
        boolean flag = registerService.register(registerForm);
        if (flag == true) {
            returnString = "register_success";
        } else {
            returnString = "register";
        }

        return returnString;
    }

    @RequestMapping("/register/activate.do")
    public ModelAndView ProcessActivate(HttpServletRequest httpServletRequest) {

        ModelAndView mav = new ModelAndView();
        //激活
        String email = httpServletRequest.getParameter("email");//获取email
        String validateCode = httpServletRequest.getParameter("validateCode");//激活码

        System.out.println("activate email" + email);

        try {
            registerService.processActivate(email, validateCode);//调用激活方法
            mav.setViewName("activate_success");
        } catch (ServiceException e) {
            mav.addObject("errorMassage", e.getMessage());
            mav.setViewName("activate_fail");
            e.printStackTrace();
        }
        return mav;

    }
}
