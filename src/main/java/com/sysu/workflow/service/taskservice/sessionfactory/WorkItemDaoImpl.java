package com.sysu.workflow.service.taskservice.sessionfactory;


import com.sysu.workflow.entity.FormEntity;
import com.sysu.workflow.entity.GroupWorkItemEntity;
import com.sysu.workflow.entity.UserWorkItemEntity;
import com.sysu.workflow.service.taskservice.WorkItemDao;
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
 * Date: 2015/12/16
 * Time: 13:16
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class WorkItemDaoImpl implements WorkItemDao {

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;

    @Transactional
    public long insertIntoWorkItem(UserWorkItemEntity workItemEntity) {

        Session session = null;
        long id = -1;
        try {
            session = sessionFactory.getCurrentSession();
           /* //½â¾öerror£ºa different object with the same identifier value was already associated with the session
            workItemEntity.setItemFormEntity((FormEntity) session.merge(workItemEntity.getItemFormEntity()));
            workItemEntity.setItemGroupWorkItemEntity((GroupWorkItemEntity) session.merge(workItemEntity.getItemGroupWorkItemEntity()));
            workItemEntity.getItemGroupWorkItemEntity().setItemCandidateGroupEntity((GroupEntity) session.merge(workItemEntity.getItemGroupWorkItemEntity().getItemCandidateGroupEntity()));
            id = (Long) session.save(workItemEntity);*/
            if (workItemEntity.getItemFormEntity() != null) {
                workItemEntity.setItemFormEntity((FormEntity) session.merge(workItemEntity.getItemFormEntity()));
                workItemEntity.setItemGroupWorkItemEntity((GroupWorkItemEntity) session.merge(workItemEntity.getItemGroupWorkItemEntity()));
                session.merge(workItemEntity);
            } else {
                session.save(workItemEntity);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return id;
    }

    @Transactional
    public long insertIntoWorkItem(GroupWorkItemEntity groupWorkItemEntity) {

        Session session = null;
        long id = -1;
        try {
            session = sessionFactory.getCurrentSession();
            id = (Long) session.save(groupWorkItemEntity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return id;
    }

    @Transactional
    public ArrayList<UserWorkItemEntity> findUserWorkItem(UserWorkItemEntity userWorkItemEntity) {
        Session session = null;
        ArrayList<UserWorkItemEntity> workItemEntityArrayList = new ArrayList<UserWorkItemEntity>();
        try {
            session = sessionFactory.getCurrentSession();

            Criteria criteria = session.createCriteria(UserWorkItemEntity.class);


            Criterion allCriterion = Restrictions.allEq(userWorkItemEntity.getNotNullPropertyMap());

            criteria.add(allCriterion);

            workItemEntityArrayList = (ArrayList<UserWorkItemEntity>) criteria.list();
            //System.out.println(workItemEntityArrayList.size());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return workItemEntityArrayList;
    }

    @Transactional
    public ArrayList<GroupWorkItemEntity> findGroupWorkItem(GroupWorkItemEntity groupWorkItemEntity) {
        Session session = null;
        ArrayList<GroupWorkItemEntity> groupWorkItemEntityArrayList = new ArrayList<GroupWorkItemEntity>();
        try {
            session = sessionFactory.getCurrentSession();

            Criteria criteria = session.createCriteria(GroupWorkItemEntity.class);

            Criterion allCriterion = Restrictions.allEq(groupWorkItemEntity.getNotNullPropertyMap());

            criteria.add(allCriterion);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            groupWorkItemEntityArrayList = (ArrayList<GroupWorkItemEntity>) criteria.list();
            //System.out.println(workItemEntityArrayList.size());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return groupWorkItemEntityArrayList;
    }

    @Transactional
    public boolean updateUserWorkItem(UserWorkItemEntity userWorkItemEntity) {
        Session session = null;
        boolean flag = false;
        try {
            session = sessionFactory.getCurrentSession();

            session.update(userWorkItemEntity);

            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return flag;
    }

    @Transactional
    public boolean updateGroupWorkItem(GroupWorkItemEntity groupWorkItemEntity) {
        Session session = null;
        boolean flag = false;
        try {
            session = sessionFactory.getCurrentSession();


            session.merge(groupWorkItemEntity);
            //session.update(groupWorkItemEntity);

            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return flag;
    }
}
