package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.DecomposeTaskDao;
import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.entity.DecomposetaskEntity;
import com.zhengshouzi.myweb.entity.DecomposetaskTaskEntity;
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


public class DecomposeTaskDaoImpl implements DecomposeTaskDao {

    @Resource(name = "judgeTaskDao")
    JudgeTaskDao judgeTaskDao;

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;


    @Override
    public boolean addDecomposeTask(DecomposetaskEntity decomposetaskEntity) {
        return false;
    }

    @Override
    public boolean deleteDecomposeTaskById(String decomposeTask_id) {
        return false;
    }

    @Override
    public boolean updateDecomposeTask(DecomposetaskTaskEntity decomposetaskTaskEntity) {
        return false;
    }

    @Transactional
    @Override
    public List<DecomposetaskEntity> findAllDecomposeTask() {
        List<DecomposetaskEntity> decomposetaskEntityList = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(DecomposetaskEntity.class);
            decomposetaskEntityList = criteria.list();
        } catch (Exception e) {
            decomposetaskEntityList = new ArrayList<>();
        } finally {
            return decomposetaskEntityList;
        }
    }

    @Override
    public DecomposetaskEntity findDecomposeTaskById(String id) {
        return null;
    }

    @Override
    public List<DecomposetaskEntity> findDecomposeTaskByCriteria(Criteria criteria) {
        return null;
    }
}
