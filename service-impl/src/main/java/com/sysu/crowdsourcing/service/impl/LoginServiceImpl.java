package com.sysu.crowdsourcing.service.impl;

import com.sysu.crowdsourcing.manager.UserManager;
import com.sysu.crowdsourcing.service.LoginService;
import com.sysu.model.workflow.UserEntity;

import javax.annotation.Resource;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class LoginServiceImpl implements LoginService {

    @Resource(name = "userDao")
    UserManager userDao;


    public boolean login(UserEntity userEntity) {


        return false;
    }

    public UserEntity getUserByEmail(String email) {


        return null;
    }
}
