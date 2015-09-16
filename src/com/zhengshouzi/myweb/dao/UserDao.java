package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.entity.UserEntity;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface UserDao {
    public boolean register(UserEntity userEntity);

    public UserEntity findUserByEmail(String email);

    public boolean checkUser(UserEntity userEntity);

    public boolean deleteUserByEmail(String email);

    public boolean updateUser(UserEntity userEntity);

    boolean updateRegisterStatus(String email, String status);

}
