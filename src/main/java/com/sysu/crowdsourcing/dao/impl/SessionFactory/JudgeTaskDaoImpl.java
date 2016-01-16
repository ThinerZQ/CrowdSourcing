package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.JudgeTaskDao;
import com.sysu.crowdsourcing.dao.TaskDao;
import com.sysu.crowdsourcing.entity.JudgetaskEntity;
import org.hibernate.Criteria;
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
public class JudgeTaskDaoImpl implements JudgeTaskDao {

    @Resource(name = "taskDao")
    TaskDao taskDao;
    @Resource
    SessionFactory sessionFactory;

    @Transactional

    public boolean addJudgeTask(JudgetaskEntity judgetaskEntity) {
        boolean b = false;
        try {
            Session session = sessionFactory.getCurrentSession();

            Serializable id = (Serializable) session.save(judgetaskEntity);

           /* if (id != 0 || id != null) {
                b = true;
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            b = false;
        } finally {
            return b;
        }
    }

    @Transactional

    public List<JudgetaskEntity> findAllJudgeTask() {

        List<JudgetaskEntity> judgetaskEntityList = new ArrayList<JudgetaskEntity>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(JudgetaskEntity.class);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
            judgetaskEntityList = criteria.list();
        } catch (Exception e) {

        } finally {
            return judgetaskEntityList;
        }


    }


    public boolean deleteJudgeTask(JudgetaskEntity judgetaskEntity) {
        return false;
    }


    public boolean updateJudgeUser(JudgetaskEntity judgetaskEntity) {
        return false;
    }


}
