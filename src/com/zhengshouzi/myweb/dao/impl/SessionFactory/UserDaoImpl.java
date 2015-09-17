package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.UserDao;
import com.zhengshouzi.myweb.entity.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class UserDaoImpl implements UserDao {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean register(UserEntity userEntity) {
        Session session = sessionFactory.getCurrentSession();

        Serializable id = (Serializable) session.save(userEntity);

        if (id != 0 || id != null) {
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public UserEntity findUserByEmail(String email) {

        return null;


    }

    @Transactional
    @Override
    public boolean checkUser(UserEntity userEntity) {

        return false;
    }

    @Transactional
    @Override
    public boolean deleteUserByEmail(String email) {

        return false;
    }

    @Transactional
    @Override
    public boolean updateUser(UserEntity userEntity) {
        return false;
    }

    @Transactional
    @Override
    public boolean updateRegisterStatus(String email, String status) {

        return false;
    }


}
