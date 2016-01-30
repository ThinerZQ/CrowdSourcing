package com.sysu.workflow.service.identityservice;

import com.sysu.workflow.entity.UserEntity;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/30
 * Time: 19:37
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public interface UserDao {


    boolean addUsers(UserEntity userEntity);

    boolean checkUser(String userEmail, String userPassword);

    ArrayList<UserEntity> findUser(UserEntity userEntity);

    ArrayList<UserEntity> findUserByUserName(String userName);

    ArrayList<UserEntity> findUserByUserId(String userId);

    ArrayList<UserEntity> findUserByUserEmail(String userEmail);

    ArrayList<UserEntity> findUserByUserRealName(String userRealName);

    boolean updateUser(UserEntity userEntity);

    boolean deleteUser(UserEntity userEntity);

    boolean deleteUserById(String userId);

}
