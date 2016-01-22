package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.TaskDao;
import com.sysu.crowdsourcing.entity.TaskEntity;
import com.sysu.workflow.entity.UserWorkItemEntity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class TaskDaoImpl implements TaskDao {


    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;


    @Transactional
    public long addTask(TaskEntity taskEntity) {

        long id = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            id = (Long) session.save(taskEntity);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return id;
        }


    }

    @Transactional
    public boolean deleteTaskById(long taskId) {
        int result = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "delete TaskEntity as t where t.taskId =?";
            Query query = session.createQuery(hql);
            query.setLong(0, taskId);
            result = query.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return result == 1 ? true : false;
        }
    }

    @Transactional
    public boolean updateTask(TaskEntity taskEntity) {
        return false;
    }

    @Transactional
    public List<TaskEntity> findAllTask() {
        List<TaskEntity> taskEntityList = new ArrayList<TaskEntity>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(TaskEntity.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            taskEntityList = criteria.list();
            //Hibernate.initialize();
            //System.out.printf(taskEntityList.get(0).toString());
        } catch (Exception e) {

        } finally {
            return taskEntityList;
        }

    }

    @Transactional
    public TaskEntity findTaskById(String id) {

        return null;

    }

    @Transactional
    public List<TaskEntity> findTaskByCriteria(Criteria criteria) {
        return null;
    }

    @Transactional
    public List<UserWorkItemEntity> findAllWorkitem() {

        List<UserWorkItemEntity> workItemEntityList = new ArrayList<UserWorkItemEntity>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(TaskEntity.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            workItemEntityList = criteria.list();
            //Hibernate.initialize();
            //System.out.printf(taskEntityList.get(0).toString());
        } catch (Exception e) {

        } finally {
            return workItemEntityList;
        }

    }

}
