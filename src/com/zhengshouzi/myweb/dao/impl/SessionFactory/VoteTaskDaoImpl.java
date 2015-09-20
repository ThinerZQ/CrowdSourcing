package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.VoteTaskDao;
import com.zhengshouzi.myweb.entity.SolvetaskEntity;
import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.entity.VotetaskEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class VoteTaskDaoImpl implements VoteTaskDao {

    @Resource(name = "judgeTaskDao")
    JudgeTaskDao judgeTaskDao;

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;


    @Override
    public boolean addVoteTask(VotetaskEntity votetaskEntity) {
        return false;
    }

    @Override
    public boolean deleteVoteTaskById(String voteTask_id) {
        return false;
    }

    @Override
    public boolean updateVoteTask(VotetaskEntity votetaskEntity) {
        return false;
    }

    @Override
    public List<VotetaskEntity> findAllVoteTask() {
        List<VotetaskEntity> votetaskEntityList = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(VotetaskEntity.class);
            votetaskEntityList = criteria.list();
        } catch (Exception e) {
            votetaskEntityList = new ArrayList<>();
        } finally {
            return votetaskEntityList;
        }
    }

    @Override
    public VotetaskEntity findVoteTaskById(String voteTask_id) {
        return null;
    }

    @Override
    public List<VotetaskEntity> findVoteTaskByCriteria(Criteria criteria) {
        return null;
    }
}
