package com.sysu.crowdsourcing.service.impl;


import com.sysu.crowdsourcing.common.MD5Utils;
import com.sysu.crowdsourcing.common.MailBean;
import com.sysu.crowdsourcing.common.SendMail;
import com.sysu.crowdsourcing.manager.UserManager;
import com.sysu.crowdsourcing.service.RegisterService;
import com.sysu.model.workflow.UserEntity;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengshouzi on 2015/8/24.
 */
public class RegisterServiceImpl implements RegisterService {

    @Resource
    UserManager userManager;
    @Resource
    SendMail sendMail;


    public boolean register(UserEntity userEntity) {
        boolean b = false;

        try {
            //���ע��ĸ�����Ϣ
            userEntity.setUserRegisterDate(new Date());
            userEntity.setUserStatus(String.valueOf(0));
            userEntity.setUserActivateCode(MD5Utils.encode2hex(userEntity.getUserEmail()));

            //b = userDao.addUser(userEntity);

            if (b == true) {

                String Content = "<html><head><meta http-equiv='keywords' content='keyword1,keyword2,keyword3'>" +
                        "<meta http-equiv='description' content='this is my page'><meta http-equiv='content-type' content='text/html; charset=utf-8'>" +
                        "</head><body><h1>" + userEntity.getUserEmail()
                        + "��ã�</h1><h1>     ����������Ӽ����˺ţ�48Сʱ��Ч����������ע���˺ţ�����ֻ��ʹ��һ�Σ��뾡�켤�</br>" +
                        "<a href=http://localhost:8080/MyWeb/register/activate.do?email=" + userEntity.getUserEmail() + "&validateCode=" + userEntity.getUserActivateCode() + ">ȥ��֤</a>"
                        + "</h1><h1></h1><h1></h1><h1>  ����һ��ϵͳ�ʼ����벻�ػظ���</h1><h1>   лл��</h1><h1>" + new Date().toString() + "</h1></body></html>";

                Map map = new HashMap();
                map.put("link_address", Content);

                MailBean mailBean = new MailBean();
                mailBean.setToEmail(userEntity.getUserEmail());
                mailBean.setSubject("crowdsourcing register");
                mailBean.setFrom("601097836@qq.com");
                mailBean.setFromName("֣ǿ");
                mailBean.setData(map);

                System.out.println(mailBean.toString());
                System.out.println(Content);

                try {
                    sendMail.sendHtmlMail(mailBean);
                } catch (Exception e) {

                }
            } else {

            }
        } catch (Exception e) {
            b = false;
            e.printStackTrace();
        }

        return b;
    }


    public boolean processActivate(String email, String validateCode) {

       /* boolean b = false;

        UserEntity userEntity = userManager.findUserByEmail(email);
        System.out.println(userEntity.toString());
        //
        if (userEntity != null) {
            if (userEntity.getUserStatus().equals("0")) {
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());

                // currentTime.before(registerForm.getRegisterTime());
                if (currentTime.before(RegisterTools.getLastActivateTime(new Timestamp(userEntity.getUserRegisterDate().getTime())))) {

                    if (validateCode.equals(userEntity.getUserActivateCode())) {

                        System.out.println("==sq===" + userEntity.getUserStatus());
                        userEntity.setUserStatus(String.valueOf(1));//��״̬��Ϊ����
                        System.out.println("==sh===" + userEntity.getUserStatus());
                        userManager.updateRegisterStatus(userEntity.getUserEmail(), String.valueOf(1));
                        b = true;
                    } else {

                    }
                } else {

                }
            } else {

            }
        } else {

        }*/
        return false;

    }
}
