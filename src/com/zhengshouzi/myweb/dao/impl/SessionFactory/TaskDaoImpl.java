package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.TaskDao;
import com.zhengshouzi.myweb.entity.TaskEntity;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class TaskDaoImpl implements TaskDao {


    @Resource(name = "judgeTaskDao")
    JudgeTaskDao judgeTaskDao;

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;


    @Transactional
    @Override
    public boolean addTask(TaskEntity taskEntity) {

        boolean b = false;
        try {
            Session session = sessionFactory.getCurrentSession();

            Serializable id = (Serializable) session.save(taskEntity);

            if (id != 0 || id != null) {
                b = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        } finally {
            return b;
        }


    }

    @Override
    public boolean deleteTaskById(String task_id) {
        return false;
    }

    @Override
    public boolean updateTask(TaskEntity taskEntity) {
        return false;
    }

    @Transactional
    @Override
    public List<TaskEntity> findAllTask() {
        List<TaskEntity> taskEntityList = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(TaskEntity.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            taskEntityList = criteria.list();
           //Hibernate.initialize();
            //System.out.printf(taskEntityList.get(0).toString());
        } catch (Exception e) {
            taskEntityList = new ArrayList<>();
        } finally {
            return taskEntityList;
        }

    }

    @Override
    public TaskEntity findTaskById(String id) {

        return null;

    }

    @Override
    public List<TaskEntity> findTaskByCriteria(Criteria criteria) {
        return null;
    }

}
