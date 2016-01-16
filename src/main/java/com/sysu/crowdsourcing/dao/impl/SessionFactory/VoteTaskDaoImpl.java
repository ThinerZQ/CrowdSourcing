package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.JudgeTaskDao;
import com.sysu.crowdsourcing.dao.VoteTaskDao;
import com.sysu.crowdsourcing.entity.VotetaskEntity;
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


    public boolean addVoteTask(VotetaskEntity votetaskEntity) {
        return false;
    }


    public boolean deleteVoteTaskById(String voteTask_id) {
        return false;
    }


    public boolean updateVoteTask(VotetaskEntity votetaskEntity) {
        return false;
    }


    public List<VotetaskEntity> findAllVoteTask() {
        List<VotetaskEntity> votetaskEntityList = new ArrayList<VotetaskEntity>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(VotetaskEntity.class);
            votetaskEntityList = criteria.list();
        } catch (Exception e) {

        } finally {
            return votetaskEntityList;
        }
    }


    public VotetaskEntity findVoteTaskById(String voteTask_id) {
        return null;
    }


    public List<VotetaskEntity> findVoteTaskByCriteria(Criteria criteria) {
        return null;
    }
}
