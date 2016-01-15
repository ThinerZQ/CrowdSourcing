package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.TaskDao;
import com.zhengshouzi.myweb.entity.JudgetaskEntity;
import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.tools.DBHelper;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/7.
 */
public class JudgeTaskDaoImpl implements JudgeTaskDao {

    @Resource(name = "taskDao")
    TaskDao taskDao;
    @Resource
    SessionFactory sessionFactory;

    @Transactional
    @Override
    public boolean addJudgeTask(JudgetaskEntity judgetaskEntity) {
        boolean b = false;
        try {
            Session session = sessionFactory.getCurrentSession();

            Serializable id = (Serializable) session.save(judgetaskEntity);

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

    @Transactional
    @Override
    public List<JudgetaskEntity> findAllJudgeTask() {

        List<JudgetaskEntity> judgetaskEntityList = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(JudgetaskEntity.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            judgetaskEntityList = criteria.list();
        } catch (Exception e) {
            judgetaskEntityList = new ArrayList<>();
        } finally {
            return judgetaskEntityList;
        }


    }

    @Override
    public boolean deleteJudgeTask(JudgetaskEntity judgetaskEntity) {
        return false;
    }

    @Override
    public boolean updateJudgeUser(JudgetaskEntity judgetaskEntity) {
        return false;
    }


}
