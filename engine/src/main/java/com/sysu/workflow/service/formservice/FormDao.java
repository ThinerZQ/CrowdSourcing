package com.sysu.workflow.service.formservice;

import com.sysu.persistence.model.workflow.FormEntity;

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
public class FormDao {

    public ArrayList<FormEntity> findForm(FormEntity formEntity) {
      /*  Session session = null;
        ArrayList<FormEntity> formEntityArrayList = new ArrayList<FormEntity>();
        try {
            session = DBUtils.getSessionFactory().getCurrentSession();
            Criteria criteria = session.createCriteria(UserEntity.class);

            Criterion userCriterion = Restrictions.allEq(formEntity.getNotNullPropertyMap());
            criteria.add(userCriterion);

            formEntityArrayList = (ArrayList<FormEntity>) criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //DBUtils.closeSession(session);
        }
        return formEntityArrayList;*/
        return null;
    }
}
