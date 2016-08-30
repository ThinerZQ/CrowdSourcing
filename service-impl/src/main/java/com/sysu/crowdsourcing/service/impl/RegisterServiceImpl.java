package com.sysu.crowdsourcing.service.impl;

import com.sysu.model.crowdsourcing.beans.MailBean;
import com.sysu.model.crowdsourcing.dao.UserDao;
import com.sysu.model.crowdsourcing.exceptions.ServiceException;
import com.sysu.model.crowdsourcing.services.RegisterService;
import com.sysu.model.crowdsourcing.tools.MD5Utils;
import com.sysu.model.crowdsourcing.tools.RegisterTools;
import com.sysu.model.crowdsourcing.tools.SendMail;
import com.sysu.workflow.entity.UserEntity;

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
            //���ע��ĸ�����Ϣ
            userEntity.setUserRegisterDate(new Date());
            userEntity.setUserStatus(String.valueOf(0));
            userEntity.setUserActivateCode(MD5Utils.encode2hex(userEntity.getUserEmail()));

            //�����û���Ϣ
            b = userDao.addUser(userEntity);

            //����ɹ����ͼ����ʼ�
            if (b == true) {
                ///�����ʼ�

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
                mailBean.setSubject("�ڰ�������������");
                mailBean.setFrom("601097836@qq.com");
                mailBean.setFromName("֣ǿ");
                mailBean.setData(map);

                System.out.println(mailBean.toString());
                System.out.println(Content);

                try {
                    sendMail.sendHtmlMail(mailBean);
                } catch (Exception e) {
                    //�����ʼ�ʧ�ܣ�ɾ��ע����Ϣ
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
        //���ݷ��ʲ㣬ͨ��email��ȡ�û���Ϣ
        UserEntity userEntity = userDao.findUserByEmail(email);
        System.out.println(userEntity.toString());
        //��֤�û��Ƿ����
        if (userEntity != null) {
            //��֤�û�����״̬
            if (userEntity.getUserStatus().equals("0")) {
                ///û����
                //��ȡ��ǰʱ��
                Timestamp currentTime = new Timestamp(System.currentTimeMillis());

                //��֤�����Ƿ����
                // currentTime.before(registerForm.getRegisterTime());
                if (currentTime.before(RegisterTools.getLastActivateTime(new Timestamp(userEntity.getUserRegisterDate().getTime())))) {
                    //��֤�������Ƿ���ȷ
                    if (validateCode.equals(userEntity.getUserActivateCode())) {
                        //����ɹ��� //�������û��ļ���״̬��Ϊ�Ѽ���
                        System.out.println("==sq===" + userEntity.getUserStatus());
                        userEntity.setUserStatus(String.valueOf(1));//��״̬��Ϊ����
                        System.out.println("==sh===" + userEntity.getUserStatus());
                        userDao.updateRegisterStatus(userEntity.getUserEmail(), String.valueOf(1));
                        b = true;
                    } else {
                        throw new ServiceException("�����벻��ȷ");
                    }
                } else {
                    throw new ServiceException("�������ѹ��ڣ�");
                }
            } else {
                throw new ServiceException("�����Ѽ�����¼��");
            }
        } else {
            throw new ServiceException("������δע�ᣨ�����ַ�����ڣ���");
        }

        return b;

    }
}
