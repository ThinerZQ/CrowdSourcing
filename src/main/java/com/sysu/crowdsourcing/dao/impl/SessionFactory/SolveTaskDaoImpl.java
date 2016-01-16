package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.JudgeTaskDao;
import com.sysu.crowdsourcing.entity.TaskEntity;
import com.sysu.crowdsourcing.dao.SolveTaskDao;
import com.sysu.crowdsourcing.entity.SolvetaskEntity;
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



    public boolean addSolveTask(SolvetaskEntity solvetaskEntity) {
        return false;
    }


    public boolean deleteSolveTaskById(String solveTask_id) {
        return false;
    }


    public boolean updateSolveTask(SolvetaskEntity solvetaskEntity) {
        return false;
    }


    public List<SolvetaskEntity> findAllSolveTask() {
        List<SolvetaskEntity> solvetaskEntityList = new ArrayList<SolvetaskEntity>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(SolvetaskEntity.class);
            solvetaskEntityList = criteria.list();
        } catch (Exception e) {

        } finally {
            return solvetaskEntityList;
        }
    }


    public TaskEntity findSolveTaskById(String solveTask_id) {
        return null;
    }


    public List<SolvetaskEntity> findSolveTaskByCriteria(Criteria criteria) {
        return null;
    }
}
