package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.SolveTaskDao;
import com.zhengshouzi.myweb.entity.SolvetaskEntity;
import com.zhengshouzi.myweb.entity.TaskEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class SolveTaskDaoImpl implements SolveTaskDao {

    @Resource(name = "judgeTaskDao")
    JudgeTaskDao judgeTaskDao;

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;


    @Override
    public boolean addSolveTask(SolvetaskEntity solvetaskEntity) {
        return false;
    }

    @Override
    public boolean deleteSolveTaskById(String solveTask_id) {
        return false;
    }

    @Override
    public boolean updateSolveTask(SolvetaskEntity solvetaskEntity) {
        return false;
    }

    @Override
    public List<SolvetaskEntity> findAllSolveTask() {
        List<SolvetaskEntity> solvetaskEntityList = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(SolvetaskEntity.class);
            solvetaskEntityList = criteria.list();
        } catch (Exception e) {
            solvetaskEntityList = new ArrayList<>();
        } finally {
            return solvetaskEntityList;
        }
    }

    @Override
    public TaskEntity findSolveTaskById(String solveTask_id) {
        return null;
    }

    @Override
    public List<SolvetaskEntity> findSolveTaskByCriteria(Criteria criteria) {
        return null;
    }
}
