package com.sysu.crowdsourcing.services.impl;

import com.sysu.crowdsourcing.dao.UserDao;
import com.sysu.crowdsourcing.services.LoginService;
import com.sysu.workflow.entity.UserEntity;

import javax.annotation.Resource;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class LoginServiceImpl implements LoginService {

    @Resource(name = "userDao")
    UserDao userDao;


    public boolean login(UserEntity userEntity) {

        boolean b = userDao.checkUser(userEntity);
        return b;
    }

    public UserEntity getUserByEmail(String email) {

        return userDao.findUserByEmail(email);

    }
}
