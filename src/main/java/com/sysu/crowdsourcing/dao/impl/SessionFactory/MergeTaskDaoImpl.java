package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.JudgeTaskDao;
import com.sysu.crowdsourcing.dao.MergeTaskDao;
import com.sysu.crowdsourcing.entity.MergetaskEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
public class MergeTaskDaoImpl implements MergeTaskDao {

    @Resource(name = "judgeTaskDao")
    JudgeTaskDao judgeTaskDao;

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;


    public boolean addMergeTask(MergetaskEntity mergetaskEntity) {
        return false;
    }


    public boolean deleteMergeTaskById(String mergeTask_id) {
        return false;
    }


    public boolean updateMergeTask(MergetaskEntity mergetaskEntity) {
        return false;
    }

    @Transactional
    public List<MergetaskEntity> findAllMergeTask() {
        List<MergetaskEntity> mergetaskEntityList = new ArrayList<MergetaskEntity>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(MergetaskEntity.class);
            mergetaskEntityList = criteria.list();
        } catch (Exception e) {

        } finally {
            return mergetaskEntityList;
        }
    }


    public MergetaskEntity findMergeTaskById(String mergeTask_id) {
        return null;
    }


    public List<MergetaskEntity> findMergeTaskByCriteria(Criteria criteria) {
        return null;
    }
}
