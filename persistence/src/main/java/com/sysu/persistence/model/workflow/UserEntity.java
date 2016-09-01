package com.sysu.persistence.model.workflow;

import com.sysu.persistence.model.WorkflowEntity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Date: 2015/9/17
 * Time: 13:16
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class UserEntity implements WorkflowEntity {


    private long userId;

    private String userName;
    /*private String userRealName;*/
    private String userPassword;
    /*   private String userAge;
       private String userGender;*/
    private String userEmail;
    private String userActivateCode;
    private String userStatus;
    private Date userCreateTime;
    private Date userActiveTime;
    private Date userModifyTime;


    public UserEntity() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public UserEntity setUserName(String userName) {
        this.userName = userName;
        return this;
    }


    public String getUserPassword() {
        return userPassword;
    }

    public UserEntity setUserPassword(String userPassword) {
        this.userPassword = userPassword;
        return this;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public UserEntity setUserEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    public String getUserActivateCode() {
        return userActivateCode;
    }

    public UserEntity setUserActivateCode(String userActivateCode) {
        this.userActivateCode = userActivateCode;
        return this;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public UserEntity setUserStatus(String userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public Date getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(Date userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Date getUserActiveTime() {
        return userActiveTime;
    }

    public void setUserActiveTime(Date userActiveTime) {
        this.userActiveTime = userActiveTime;
    }

    public Date getUserModifyTime() {
        return userModifyTime;
    }

    public void setUserModifyTime(Date userModifyTime) {
        this.userModifyTime = userModifyTime;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userActivateCode='" + userActivateCode + '\'' +
                ", userStatus='" + userStatus + '\'' +
                ", userCreateTime=" + userCreateTime +
                ", userActiveTime=" + userActiveTime +
                ", userModefiyTime=" + userModifyTime +
                '}';
    }

    public Map<String, Object> getNotNullPropertyMap() {
        Map<String, Object> map = new HashMap<String, Object>();

        if (getUserId() != 0) {
            map.put("userId", getUserId());
        }

        if (getUserEmail() != null) {
            map.put("userEmail", getUserEmail());
        }
        if (getUserName() != null) {
            map.put("userName", getUserName());
        }
        if (getUserPassword() != null) {
            map.put("userPassword", getUserPassword());
        }
        return map;
    }
}
