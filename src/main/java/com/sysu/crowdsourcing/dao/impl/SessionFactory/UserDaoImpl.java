package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.UserDao;
import com.sysu.workflow.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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


    @Transactional
    public boolean addUser(UserEntity userEntity) {
        boolean b = false;
        try {
            Session session = sessionFactory.getCurrentSession();

            Serializable id = (Serializable) session.save(userEntity);

           /* if (id != 0 || id != null) {
                b = true;
            }*/
        } catch (HibernateException e) {
            e.printStackTrace();
            b = false;
        } finally {
            return b;
        }
    }

    @Transactional

    public UserEntity findUserByEmail(String email) {
        UserEntity userEntity = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion criterion = Restrictions.eq("userEmail", email);
            criteria.add(criterion);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            List<UserEntity> userEntityList = criteria.list();

            if (userEntityList.size() == 1) {
                userEntity = new UserEntity();
                userEntity = userEntityList.get(0);
            }

        } catch (Exception e) {
            userEntity = new UserEntity();
        } finally {
            return userEntity;
        }
    }


    public UserEntity findUserById(String user_id) {
        return null;
    }


    public List<UserEntity> findAllUser() {
        return null;
    }


    public List<UserEntity> findUserByCriteria(Criteria criteria) {
        return null;
    }

    @Transactional
    public boolean checkUser(UserEntity userEntity) {

        boolean b = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion criterion = Restrictions.allEq(userEntity.getNotNullPropertyMap());
            criteria.add(criterion);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            List<UserEntity> userEntityList = criteria.list();
            if (userEntityList.size() == 1) {
                b = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        } finally {
            return b;
        }
    }

    @Transactional
    public boolean deleteUserByEmail(String email) {

        boolean b = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion criterion = Restrictions.eq("email", email);
            criteria.add(criterion);

            List<UserEntity> userEntityList = criteria.list();

            if (userEntityList.size() == 1) {
                session.delete(userEntityList.get(0));
                b = true;
            } else {
                b = false;
            }
        } catch (Exception e) {
            b = false;
        } finally {
            return b;
        }
    }


    public boolean deleteUserById(String user_id) {
        return false;
    }

    @Transactional
    public boolean updateUser(UserEntity userEntity) {
        boolean b = false;
        try {
            Session session = sessionFactory.getCurrentSession();

            UserEntity userEntity1 = (UserEntity) session.load(UserEntity.class, userEntity.getUserId());

            userEntity1 = userEntity;
            session.update(userEntity1);

            b = true;
        } catch (Exception e) {
            b = false;
        } finally {
            return b;
        }

    }

    @Transactional
    public boolean updateRegisterStatus(String email, String status) {
        boolean b = false;

        try {
            //Session session  = sessionFactory.getCurrentSession();
            UserEntity userEntity = findUserByEmail(email);

            userEntity.setUserStatus(status);
            updateUser(userEntity);
            b = true;
        } catch (HibernateException e) {
            e.printStackTrace();
            b = false;
        } finally {
            return b;
        }
    }


}
