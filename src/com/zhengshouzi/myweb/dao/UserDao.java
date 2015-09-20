package com.zhengshouzi.myweb.dao;

import com.zhengshouzi.myweb.entity.UserEntity;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public interface UserDao {
    boolean addUser(UserEntity userEntity);

    boolean deleteUserByEmail(String email);

    boolean deleteUserById(String user_id);

    boolean updateUser(UserEntity userEntity);

    UserEntity findUserByEmail(String email);

    UserEntity findUserById(String user_id);

    List<UserEntity> findAllUser();

    List<UserEntity> findUserByCriteria(Criteria criteria);

    boolean checkUser(UserEntity userEntity);

    boolean updateRegisterStatus(String email, String status);


}
