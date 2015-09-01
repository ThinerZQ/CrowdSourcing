package com.zhengshouzi.myweb.forms;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zhengshouzi on 2015/8/24.
 */
public class RegisterForm {
    private String email;
    private String password;
    private String status = String.valueOf(0);//����״̬
    private String activatecode;//������
    private Timestamp registerTime;//ע��ʱ��

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getActivatecode() {
        return activatecode;
    }

    public void setActivatecode(String activatecode) {
        this.activatecode = activatecode;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                ", activatecode='" + activatecode + '\'' +
                ", registerTime=" + registerTime +
                '}';
    }

    public Date getLastActivateTime() {
        Calendar cl = Calendar.getInstance();
        cl.setTime(registerTime);
        cl.add(Calendar.DATE, 2);

        return cl.getTime();
    }

}
