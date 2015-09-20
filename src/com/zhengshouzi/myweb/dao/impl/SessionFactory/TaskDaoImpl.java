package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.TaskDao;
import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

        boolean b =false;
        try {
            Session session = sessionFactory.getCurrentSession();

            Serializable id = (Serializable) session.save(taskEntity);

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

    @Override
    public List<TaskEntity> findAllTask() {
        List<TaskEntity> taskEntityList =null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(TaskEntity.class);
            taskEntityList =criteria.list();
        }catch (Exception e){
           taskEntityList = new ArrayList<>();
        }finally {
            return  taskEntityList;
        }

    }

    @Override
    public List deleteTask(TaskEntity taskEntity) {
        return null;
    }


    @Override
    public boolean updateUser(UserEntity userEntity) {
        return false;
    }

    @Override
    public TaskEntity findTaskById(String id) {

        return null;

    }

}
