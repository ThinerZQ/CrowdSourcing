package com.sysu.workflow.service.identityservice.sessionfactory;

import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.service.identityservice.UserDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2015/12/15
 * Time: 13:16
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class UserDaoImpl implements UserDao {

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;

    /**
     * @param userEntity
     * @return
     */
    @Transactional
    public boolean addUsers(UserEntity userEntity) {

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();

            session.save(userEntity);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return true;
    }

    /**
     * @param userEmail
     * @param userPassword
     * @return
     */
    @Transactional
    public boolean checkUser(String userEmail, String userPassword) {

        Session session = null;
        UserEntity userEntity = null;
        try {
            session = sessionFactory.getCurrentSession();

            Criteria criteria = session.createCriteria(UserEntity.class);
            Criterion userEmailCriterion = Restrictions.eq("userEmail", userEmail);
            Criterion userPasswordCriterion = Restrictions.eq("userPassword", userPassword);
            criteria.add(userEmailCriterion);
            criteria.add(userPasswordCriterion);
            List<UserEntity> userEntityList = criteria.list();

            if (userEntityList.size() == 1) {
                userEntity = userEntityList.get(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return userEntity != null ? true : false;

    }

    @Transactional
    public ArrayList<UserEntity> findUser(UserEntity userEntity) {
        Session session = null;
        ArrayList<UserEntity> userEntityArrayList = new ArrayList<UserEntity>();
        try {
            session = sessionFactory.getCurrentSession();

            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion userCriterion = Restrictions.allEq(userEntity.getNotNullPropertyMap());
            criteria.add(userCriterion);

            userEntityArrayList = (ArrayList<UserEntity>) criteria.list();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return userEntityArrayList;
    }

    @Transactional
    public ArrayList<UserEntity> findUserByUserName(String userName) {

        Session session = null;
        ArrayList<UserEntity> userEntityArrayList = new ArrayList<UserEntity>();
        try {
            session = sessionFactory.getCurrentSession();

            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion userEmailCriterion = Restrictions.eq("userName", userName);
            criteria.add(userEmailCriterion);

            userEntityArrayList = (ArrayList<UserEntity>) criteria.list();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return userEntityArrayList;

    }

    @Transactional
    public ArrayList<UserEntity> findUserByUserId(String userId) {
        Session session = null;
        ArrayList<UserEntity> userEntityArrayList = new ArrayList<UserEntity>();
        try {
            session = sessionFactory.getCurrentSession();

            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion userEmailCriterion = Restrictions.eq("userId", userId);
            criteria.add(userEmailCriterion);

            userEntityArrayList = (ArrayList<UserEntity>) criteria.list();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return userEntityArrayList;
    }

    @Transactional
    public ArrayList<UserEntity> findUserByUserEmail(String userEmail) {
        Session session = null;
        ArrayList<UserEntity> userEntityArrayList = new ArrayList<UserEntity>();
        try {
            session = sessionFactory.getCurrentSession();

            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion userEmailCriterion = Restrictions.eq("userEmail", userEmail);
            criteria.add(userEmailCriterion);

            userEntityArrayList = (ArrayList<UserEntity>) criteria.list();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return userEntityArrayList;
    }

    @Transactional
    public ArrayList<UserEntity> findUserByUserRealName(String userRealName) {
        return null;
    }

    @Transactional
    public boolean updateUser(UserEntity userEntity) {
        return false;
    }

    @Transactional
    public boolean deleteUser(UserEntity userEntity) {
        return false;
    }

    @Transactional
    public boolean deleteUserById(String userId) {
        return false;
    }

}
