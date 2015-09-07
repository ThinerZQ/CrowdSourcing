package com.zhengshouzi.myweb.servicesimpl;

import com.zhengshouzi.myweb.beans.User;
import com.zhengshouzi.myweb.dao.UserDao;
import com.zhengshouzi.myweb.services.LoginService;

import javax.annotation.Resource;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class LoginServiceImpl implements LoginService {

    @Resource(name = "userDao")
    UserDao userDao;

    @Override
    public boolean login(User user) {

        boolean b = userDao.checkUser(user);

        return b;
    }
    public User getUserByEmail(String email){

        return userDao.findUserByEmail(email);

    }
}
