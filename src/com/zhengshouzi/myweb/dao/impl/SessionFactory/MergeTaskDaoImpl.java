package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.MergeTaskDao;
import com.zhengshouzi.myweb.entity.MergetaskEntity;
import com.zhengshouzi.myweb.entity.TaskEntity;
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

    @Override
    public boolean addMergeTask(MergetaskEntity mergetaskEntity) {
        return false;
    }

    @Override
    public boolean deleteMergeTaskById(String mergeTask_id) {
        return false;
    }

    @Override
    public boolean updateMergeTask(MergetaskEntity mergetaskEntity) {
        return false;
    }

    @Transactional
    @Override
    public List<MergetaskEntity> findAllMergeTask() {
        List<MergetaskEntity> mergetaskEntityList = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(MergetaskEntity.class);
            mergetaskEntityList = criteria.list();
        } catch (Exception e) {
            mergetaskEntityList = new ArrayList<>();
        } finally {
            return mergetaskEntityList;
        }
    }

    @Override
    public MergetaskEntity findMergeTaskById(String mergeTask_id) {
        return null;
    }

    @Override
    public List<MergetaskEntity> findMergeTaskByCriteria(Criteria criteria) {
        return null;
    }
}
