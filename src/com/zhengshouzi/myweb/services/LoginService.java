package com.zhengshouzi.myweb.services;

import com.zhengshouzi.myweb.beans.User;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface LoginService  {

    public boolean login(User user);
    public User getUserByEmail(String email);
}
