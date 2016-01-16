package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.JudgeTaskDao;
import com.sysu.crowdsourcing.dao.DecomposeTaskDao;
import com.sysu.crowdsourcing.entity.DecomposetaskEntity;
import com.sysu.crowdsourcing.entity.DecomposetaskTaskEntity;
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



    public boolean addDecomposeTask(DecomposetaskEntity decomposetaskEntity) {
        return false;
    }


    public boolean deleteDecomposeTaskById(String decomposeTask_id) {
        return false;
    }


    public boolean updateDecomposeTask(DecomposetaskTaskEntity decomposetaskTaskEntity) {
        return false;
    }

    @Transactional

    public List<DecomposetaskEntity> findAllDecomposeTask() {
        List<DecomposetaskEntity> decomposetaskEntityList = new ArrayList<DecomposetaskEntity>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(DecomposetaskEntity.class);
            decomposetaskEntityList = criteria.list();
        } catch (Exception e) {

        } finally {
            return decomposetaskEntityList;
        }
    }


    public DecomposetaskEntity findDecomposeTaskById(String id) {
        return null;
    }


    public List<DecomposetaskEntity> findDecomposeTaskByCriteria(Criteria criteria) {
        return null;
    }
}
