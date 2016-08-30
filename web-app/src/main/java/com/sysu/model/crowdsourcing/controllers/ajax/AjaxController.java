package com.sysu.model.crowdsourcing.controllers.ajax
        ;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by ǿ on 2015/8/27.
 */
@Controller
public class AjaxController {

    @RequestMapping("/verifyCheckCode.do")
    public void verifyCheckCode(HttpServletRequest httpServletRequest, HttpSession httpSession, HttpServletResponse httpServletResponse) throws IOException {


        String checkCode = httpServletRequest.getParameter("checkCode");
        String rightChechCode = (String) httpSession.getAttribute("checkCode");

        System.out.println(checkCode);
        System.out.println(rightChechCode);
        PrintWriter printWriter = httpServletResponse.getWriter();
        if (rightChechCode.equalsIgnoreCase(checkCode)) {
            System.out.println(" checkcode right");
            printWriter.write("right");
        } else {
            System.out.println(" checkcode error");
            printWriter.write("error");
        }
    }
}
