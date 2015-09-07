package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.beans.User;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface UserDao {
    public boolean addUser(User user);
    public User findUserByEmail(String email);
    public boolean checkUser(User user);
    public boolean deleteUserByEmail(String email);
    public boolean updateUser(User user);

}
