package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.CrowdSourcingTaskDao;
import com.sysu.crowdsourcing.entity.CrowdSourcingTask;
import com.sysu.workflow.entity.UserWorkItemEntity;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class CrowdSourcingTaskDaoImpl implements CrowdSourcingTaskDao {


    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;


    @Transactional
    public long addTask(CrowdSourcingTask crowdSourcingTask) {

        long id = -1;
        try {
            Session session = sessionFactory.getCurrentSession();
            id = (Long) session.save(crowdSourcingTask);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return id;
        }


    }

    @Transactional
    public boolean addTask(Set<CrowdSourcingTask> crowdSourcingTaskArrayList) {
        boolean flag = true;
        for (CrowdSourcingTask crowdSourcingTask : crowdSourcingTaskArrayList) {
            long id = -1;
            try {
                Session session = sessionFactory.getCurrentSession();
                id = (Long) session.save(crowdSourcingTask);
                if (id == -1) {
                    flag = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
            }
        }
        return flag;
    }

    @Transactional
    public boolean deleteTaskById(long taskId) {
        int result = 0;
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "delete CrowdSourcingTask as t where t.taskId =?";
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
    public CrowdSourcingTask getCrowdSourcingTaskByProcessInstanceId(long processInstanceId) {


        CrowdSourcingTask crowdSourcingTask = new CrowdSourcingTask();
        try {
            Session session = sessionFactory.getCurrentSession();
            String hql = "select * from t_crowdsourcingtask where processInstanceId =" + processInstanceId;
            SQLQuery query = session.createSQLQuery(hql).addEntity(CrowdSourcingTask.class);
            List<CrowdSourcingTask> crowdSourcingTasks = query.list();

            if (crowdSourcingTasks.size() == 1) {
                crowdSourcingTask = crowdSourcingTasks.listIterator().next();
            } else {
                System.out.println("no crowdSourcingTask");
            }

            System.out.println(crowdSourcingTask);
            //Hibernate.initialize();
            //System.out.printf(taskEntityList.get(0).toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return crowdSourcingTask;
        }
    }

    @Transactional
    public boolean updateCrowdSourcingTask(CrowdSourcingTask crowdSourcingTask) {
        boolean flag = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            session.merge(crowdSourcingTask);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    @Transactional
    public List<CrowdSourcingTask> getCrowdSourcingTask(CrowdSourcingTask crowdSourcingTask) {
        List<CrowdSourcingTask> crowdSourcingTaskList = new ArrayList<CrowdSourcingTask>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(CrowdSourcingTask.class);
            Criterion criterion = Restrictions.allEq(crowdSourcingTask.getNotNullPropertyMap());
            criteria.add(criterion);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            crowdSourcingTaskList = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return crowdSourcingTaskList;
        }
    }

    @Transactional
    public boolean updateTask(CrowdSourcingTask crowdSourcingTask) {
        return false;
    }

    @Transactional
    public List<CrowdSourcingTask> findAllTask() {
        List<CrowdSourcingTask> crowdSourcingTaskList = new ArrayList<CrowdSourcingTask>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(CrowdSourcingTask.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            crowdSourcingTaskList = criteria.list();
            //Hibernate.initialize();
            //System.out.printf(taskEntityList.get(0).toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return crowdSourcingTaskList;
        }

    }

    @Transactional
    public CrowdSourcingTask findTaskById(String id) {

        return null;

    }

    @Transactional
    public List<CrowdSourcingTask> findTaskByCriteria(Criteria criteria) {
        return null;
    }

    @Transactional
    public List<UserWorkItemEntity> findAllWorkitem() {

        List<UserWorkItemEntity> workItemEntityList = new ArrayList<UserWorkItemEntity>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(CrowdSourcingTask.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            workItemEntityList = criteria.list();
            //Hibernate.initialize();
            //System.out.printf(taskEntityList.get(0).toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return workItemEntityList;
        }

    }

}
