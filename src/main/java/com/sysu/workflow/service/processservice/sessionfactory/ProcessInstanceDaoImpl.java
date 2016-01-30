package com.sysu.workflow.service.processservice.sessionfactory;

import com.sysu.workflow.entity.ProcessInstanceEntity;
import com.sysu.workflow.service.processservice.ProcessInstanceDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/18
 * Time: 21:10
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
public class ProcessInstanceDaoImpl implements ProcessInstanceDao {

    @Resource(name = "sessionFactory")
    SessionFactory sessionFactory;

    /**
     * @param processInstanceEntity
     * @return
     */
    @Transactional
    public boolean addProcessInstance(ProcessInstanceEntity processInstanceEntity) {

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();


            session.save(processInstanceEntity);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return true;
    }


    @Transactional
    public ArrayList<ProcessInstanceEntity> findProcessInstanceByProcessName(String processName) {
        return null;
    }

    @Transactional
    public ArrayList<ProcessInstanceEntity> findProcessInstance(ProcessInstanceEntity ProcessInstanceEntity) {
        return null;
    }

    @Transactional
    public ProcessInstanceEntity findProcessInstanceByProcessInstanceId(String processInstanceId) {
        return null;
    }

    @Transactional
    public boolean updateProcessInstance(ProcessInstanceEntity processInstanceEntity) {
        return false;
    }

    @Transactional
    public boolean deleteProcessInstance(ProcessInstanceEntity processInstanceEntity) {
        return false;
    }

    @Transactional
    public ArrayList<ProcessInstanceEntity> getAllProcessInstance() {
        Session session = null;
        ArrayList<ProcessInstanceEntity> processInstanceEntities = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            String hql = "select processInstance from ProcessInstanceEntity as processInstance";
            processInstanceEntities = (ArrayList<ProcessInstanceEntity>) session.createQuery(hql).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
        return processInstanceEntities;

    }
}
