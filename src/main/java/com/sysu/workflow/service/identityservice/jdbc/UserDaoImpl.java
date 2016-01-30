package com.sysu.workflow.service.identityservice.jdbc;

import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.service.identityservice.UserDao;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/30
 * Time: 19:40
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class UserDaoImpl implements UserDao {

    public boolean addUsers(UserEntity userEntity) {


        return true;
    }

    public boolean checkUser(String userEmail, String userPassword) {


        return false;

    }

    public ArrayList<UserEntity> findUser(UserEntity userEntity) {

        return null;
    }

    public ArrayList<UserEntity> findUserByUserName(String userName) {


        return null;

    }

    public ArrayList<UserEntity> findUserByUserId(String userId) {

        return null;
    }

    public ArrayList<UserEntity> findUserByUserEmail(String userEmail) {
        return null;
    }

    public ArrayList<UserEntity> findUserByUserRealName(String userRealName) {
        return null;
    }


    public boolean updateUser(UserEntity userEntity) {
        return false;
    }

    public boolean deleteUser(UserEntity userEntity) {
        return false;
    }

    public boolean deleteUserById(String userId) {
        return false;
    }


}
