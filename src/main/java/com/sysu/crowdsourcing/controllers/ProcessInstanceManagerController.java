package com.sysu.crowdsourcing.controllers;

import com.sysu.workflow.entity.ProcessInstanceEntity;
import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.service.processservice.RuntimeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/20
 * Time: 13:24
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
@Controller
public class ProcessInstanceManagerController {

    @RequestMapping("/manage.do")
    public ModelAndView manage(@ModelAttribute UserEntity userEntity, HttpSession httpSession) {

        System.out.println("-------manage.do---------");

        ModelAndView modelAndView = new ModelAndView();
        ArrayList<ProcessInstanceEntity> processInstanceEntityArrayList = RuntimeService.createProcessInstanceQuery().getAllProcessInstance();
        modelAndView.addObject("processInstanceEntityArrayList", processInstanceEntityArrayList);
        modelAndView.setViewName("manager");

        return modelAndView;
    }
}
