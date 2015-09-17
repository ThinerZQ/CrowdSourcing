package com.zhengshouzi.myweb.dao.impl.SessionFactory;

import com.zhengshouzi.myweb.dao.DescriptionDao;
import com.zhengshouzi.myweb.entity.DescriptionEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;

public class DescriptionDaoImpl implements DescriptionDao {


    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;


    @Transactional
    @Override
    public boolean addDescriptionTask(DescriptionEntity descriptionEntity) {
        Session session = sessionFactory.getCurrentSession();

        Serializable id = (Serializable) session.save(descriptionEntity);

        return true;
    }

    @Override
    public ArrayList<DescriptionEntity> findAllTask() {
        return null;
    }

    @Override
    public boolean deleteTask(DescriptionEntity descriptionEntity) {
        return false;
    }

    @Override
    public DescriptionEntity findTaskById(String id) {
        return null;
    }
}