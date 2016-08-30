package com.sysu.model.crowdsourcing.controllers;

import com.sysu.model.crowdsourcing.exceptions.ServiceException;
import com.sysu.model.crowdsourcing.services.RegisterService;
import com.sysu.workflow.entity.UserEntity;
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


    @RequestMapping("/register/register.do")
    public String proccessRegister(@ModelAttribute UserEntity userEntity) {

        String returnString = null;
        System.out.print(userEntity.getUserEmail());
        System.out.println("-------/register/register.do-----------");
        boolean flag = registerService.register(userEntity);
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
        //����
        String email = httpServletRequest.getParameter("email");//��ȡemail
        String validateCode = httpServletRequest.getParameter("validateCode");//������

        System.out.println("activate email" + email);

        try {
            registerService.processActivate(email, validateCode);//���ü����
            mav.setViewName("activate_success");
        } catch (ServiceException e) {
            mav.addObject("errorMassage", e.getMessage());
            mav.setViewName("activate_fail");
            e.printStackTrace();
        }
        return mav;

    }
}
