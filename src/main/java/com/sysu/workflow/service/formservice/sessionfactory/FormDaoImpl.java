package com.sysu.workflow.service.formservice.sessionfactory;

import com.sysu.workflow.entity.FormEntity;
import com.sysu.workflow.entity.UserEntity;
import com.sysu.workflow.service.formservice.FormDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/22
 * Time: 13:38
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class FormDaoImpl implements FormDao {

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;

    @Transactional
    public ArrayList<FormEntity> findForm(FormEntity formEntity) {
        Session session = null;
        ArrayList<FormEntity> formEntityArrayList = new ArrayList<FormEntity>();
        try {
            session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion userCriterion = Restrictions.allEq(formEntity.getNotNullPropertyMap());
            criteria.add(userCriterion);

            formEntityArrayList = (ArrayList<FormEntity>) criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return formEntityArrayList;
    }
}
