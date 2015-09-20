package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.UserDao;
import com.zhengshouzi.myweb.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class UserDaoImpl implements UserDao {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Override
    @Transactional
    public boolean register(UserEntity userEntity) {
        boolean b =false;
        try {
            Session session = sessionFactory.getCurrentSession();

            Serializable id = (Serializable) session.save(userEntity);

            if (id != 0 || id != null) {
                b= true;
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            b=false;
        } finally {
            return b;
        }
    }

    @Transactional
    @Override
    public UserEntity findUserByEmail(String email) {
        UserEntity userEntity = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion criterion = Restrictions.eq("email",email);
            criteria.add(criterion);

            List<UserEntity> userEntityList = criteria.list();

            if (userEntityList.size()==1) {
                userEntity = new UserEntity();
                userEntity= userEntityList.get(0);
            }

        }catch (Exception e){
            userEntity = new UserEntity();
        }finally {
            return  userEntity;
        }


    }

    @Transactional
    @Override
    public boolean checkUser(UserEntity userEntity) {

        boolean b =false;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion criterion = Restrictions.eq("email", userEntity.getEmail());
            criteria.add(criterion);

            List<UserEntity> userEntityList = criteria.list();

            if (userEntityList.size() == 1) {
                if (userEntity.getPassword().trim() == userEntityList.get(0).getPassword().trim()) {
                    b= true;
                }
            }
        }catch (Exception e){
            b=false;
        }finally {
            return  b;
        }
    }

    @Transactional
    @Override
    public boolean deleteUserByEmail(String email) {

        boolean b=false;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion criterion = Restrictions.eq("email", email);
            criteria.add(criterion);

            List<UserEntity> userEntityList = criteria.list();

            if (userEntityList.size() == 1) {
                session.delete(userEntityList.get(0));
               b=true;
            }else {
                b=false;
            }
        }catch (Exception e){
            b=false;
        }finally {
            return b;
        }
    }

    @Transactional
    @Override
    public boolean updateUser(UserEntity userEntity) {
        boolean b =false;
        try{
            Session session = sessionFactory.getCurrentSession();

            UserEntity userEntity1 = (UserEntity) session.load(UserEntity.class, userEntity.getId());

            userEntity1 = userEntity;
            session.update(userEntity1);

            b=  true;
        }catch (Exception e){
            b= false;
        }finally {
return  b ;
        }

    }

    @Transactional
    @Override
    public boolean updateRegisterStatus(String email, String status) {
        boolean b=false;

        try {
            Session session  = sessionFactory.getCurrentSession();
            UserEntity userEntity = findUserByEmail(email);

            userEntity.setStatus(status);
            updateUser(userEntity);
            b=true;
        } catch (HibernateException e) {
            e.printStackTrace();
            b=false;
        } finally {
            return b;
        }


    }


}
