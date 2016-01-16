package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.beans.MailBean;
import com.sysu.crowdsourcing.dao.UserDao;
import com.sysu.crowdsourcing.exceptions.ServiceException;
import com.sysu.crowdsourcing.services.RegisterService;
import com.sysu.crowdsourcing.tools.MD5Utils;
import com.sysu.crowdsourcing.tools.RegisterTools;
import com.sysu.crowdsourcing.tools.SendMail;
import com.sysu.workflow.service.indentityservice.UserEntity;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengshouzi on 2015/8/24.
 */
public class RegisterServiceImpl implements RegisterService {

    @Resource(name = "userDao")
    UserDao userDao;
    @Resource(name = "sendMail")
    SendMail sendMail;


    public boolean register(UserEntity userEntity) {
        boolean b = false;

        try {
            //添加注册的附加信息
            userEntity.setUserRegisterDate(new Date());
            userEntity.setUserStatus(String.valueOf(0));
            userEntity.setUserActivateCode(MD5Utils.encode2hex(userEntity.getUserEmail()));

            //保存用户信息
            b = userDao.addUser(userEntity);

            //保存成功发送激活邮件
            if (b == true) {
                ///发送邮件

                String Content = "<html><head><meta http-equiv='keywords' content='keyword1,keyword2,keyword3'>" +
                        "<meta http-equiv='description' content='this is my page'><meta http-equiv='content-type' content='text/html; charset=utf-8'>" +
                        "</head><body><h1>" + userEntity.getUserEmail()
                        + "你好：</h1><h1>     点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>" +
                        "<a href=http://localhost:8080/MyWeb/register/activate.do?email=" + userEntity.getUserEmail() + "&validateCode=" + userEntity.getUserActivateCode() + ">去验证</a>"
                        + "</h1><h1></h1><h1></h1><h1>  这是一封系统邮件，请不必回复！</h1><h1>   谢谢！</h1><h1>" + new Date().toString() + "</h1></body></html>";

                Map map = new HashMap();
                map.put("link_address", Content);

                MailBean mailBean = new MailBean();
                mailBean.setToEmail(userEntity.getUserEmail());
                mailBean.setSubject("众包社区激活链接");
                mailBean.setFrom("601097836@qq.com");
                mailBean.setFromName("郑强");
                mailBean.setData(map);

                System.out.println(mailBean.toString());
                System.out.println(Content);

                try {
                    sendMail.sendHtmlMail(mailBean);
                } catch (Exception e) {
                    //发送邮件失败，删除注册信息
                    b = false;
                    userDao.deleteUserByEmail(userEntity.getUserEmail());
                    e.printStackTrace();
                }
            } else {

            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }

        return b;
    }


    public boolean processActivate(String email, String validateCode) throws ServiceException {

        boolean b = false;
        //数据访问层，通过email获取用户信息
        UserEntity userEntity = userDao.findUserByEmail(email);
        System.out.println(userEntity.toString());
        //验证用户是否存在
        if (userEntity != null) {
            //验证用户激活状态
            if (userEntity.getUserStatus().equals("0")) {
                ///没激活
                //获取当前时间
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());

                //验证链接是否过期
                // currentTime.before(registerForm.getRegisterTime());
                if (currentTime.before(RegisterTools.getLastActivateTime(new Timestamp(userEntity.getUserRegisterDate().getTime())))) {
                    //验证激活码是否正确
                    if (validateCode.equals(userEntity.getUserActivateCode())) {
                        //激活成功， //并更新用户的激活状态，为已激活
                        System.out.println("==sq===" + userEntity.getUserStatus());
                        userEntity.setUserStatus(String.valueOf(1));//把状态改为激活
                        System.out.println("==sh===" + userEntity.getUserStatus());
                        userDao.updateRegisterStatus(userEntity.getUserEmail(), String.valueOf(1));
                        b = true;
                    } else {
                        throw new ServiceException("激活码不正确");
                    }
                } else {
                    throw new ServiceException("激活码已过期！");
                }
            } else {
                throw new ServiceException("邮箱已激活，请登录！");
            }
        } else {
            throw new ServiceException("该邮箱未注册（邮箱地址不存在）！");
        }

        return b;

    }
}
