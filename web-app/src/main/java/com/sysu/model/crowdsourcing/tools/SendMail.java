package com.sysu.model.crowdsourcing.tools;

/**
 * Created by zhengshouzi on 2015/8/24.
 */

import com.sysu.model.crowdsourcing.beans.MailBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

/**
 * @author Qixuan.Chen
 */
public class SendMail {

    @Resource(name = "mailSender")
    private JavaMailSender javaMailSender;

    public boolean sendSimpleMail(MailBean mailBean) throws MessagingException {

        SimpleMailMessage mail = new SimpleMailMessage();
        try {
            mail.setTo(mailBean.getToEmail());// ������
            mail.setFrom(mailBean.getFrom());// ������
            mail.setSubject(mailBean.getSubject());// ����
            mail.setText(mailBean.getText());// �ʼ�����

            javaMailSender.send(mail);

            System.out.println("�������");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean sendHtmlMail(MailBean mailBean) throws javax.mail.MessagingException {

        javax.mail.internet.MimeMessage mm = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mm, true, "utf-8");

        if (checkMailBean(mailBean)) {
            try {
                helper.setTo(mailBean.getToEmail());// ������
                helper.setFrom(mailBean.getFrom(), mailBean.getFromName());// ������
                helper.setSubject(mailBean.getSubject());// ����
                helper.setText((String) mailBean.getData().get("link_address"), true);// �ڶ������������͵���������html

                System.out.println(mailBean.toString());


                javaMailSender.send(mm);
                System.out.println("�������");
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    public boolean sendFileMail(MailBean mailBean) throws javax.mail.MessagingException {
        MimeMessage mm = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mm, true, "GBK");
        try {
            helper.setTo(mailBean.getToEmail());// ������
            helper.setFrom(mailBean.getFrom(), mailBean.getFromName());// ������
            helper.setSubject(mailBean.getSubject());// ����

            helper.setText(mailBean.getText());// �ʼ�����
            //��������ļ�
            ClassPathResource in = new ClassPathResource("lmm.txt");
            ClassPathResource in2 = new ClassPathResource("attachment.txt");

            //MimeUtility.encodeWord()����������ļ���Ϊ��������
            helper.addAttachment(MimeUtility.encodeWord(in.getFilename()), in);
            helper.addAttachment(MimeUtility.encodeWord(in2.getFilename()), in2);

            javaMailSender.send(mm);
            System.out.println("�������");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    /*
     * check �ʼ�
     */
    private boolean checkMailBean(MailBean mailBean) {
        if (mailBean == null) {
            return false;
        }
        if (mailBean.getSubject() == null) {
            return false;
        }
        if (mailBean.getToEmail() == null) {
            return false;
        }
        if (mailBean.getFrom() == null) {
            return false;
        }
        return true;
    }


}
