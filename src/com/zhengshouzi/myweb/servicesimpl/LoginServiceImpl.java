package com.zhengshouzi.myweb.servicesimpl;

import com.zhengshouzi.myweb.dao.UserDao;
import com.zhengshouzi.myweb.entity.UserEntity;
import com.zhengshouzi.myweb.services.LoginService;

import javax.annotation.Resource;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class LoginServiceImpl implements LoginService {

    @Resource(name = "userDao")
    UserDao userDao;

    @Override
    public boolean login(UserEntity userEntity) {

        boolean b = userDao.checkUser(userEntity);

        return b;
    }
    public UserEntity getUserByEmail(String email){

        return userDao.findUserByEmail(email);

    }
}
