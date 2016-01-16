package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.DescriptionDao;
import com.sysu.crowdsourcing.entity.DescriptionEntity;
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

    public boolean addDescription(DescriptionEntity descriptionEntity) {
        Session session = sessionFactory.getCurrentSession();

        Serializable id = (Serializable) session.save(descriptionEntity);

        return true;
    }


    public boolean deleteDescription(DescriptionEntity descriptionEntity) {
        return false;
    }


    public boolean updateDescription(DescriptionEntity descriptionEntity) {
        return false;
    }


    public ArrayList<DescriptionEntity> findAllTask() {
        return null;
    }


    public DescriptionEntity findDescriptionById(String id) {
        return null;
    }
}