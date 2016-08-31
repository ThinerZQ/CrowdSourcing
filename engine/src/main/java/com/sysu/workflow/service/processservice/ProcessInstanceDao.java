package com.sysu.workflow.service.processservice;

import com.sysu.model.workflow.ProcessInstanceEntity;

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
public class ProcessInstanceDao {
    /**
     * @param processInstanceEntity
     * @return
     */
    public boolean addProcessInstance(ProcessInstanceEntity processInstanceEntity) {

       /* Session session = null;
        boolean flag = false;
        try {
            session = DBUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            session.save(processInstanceEntity);

            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //DBUtils.closeSession(session);
        }
        return flag;*/
        return false;
    }


    public boolean updateProcessInstance(ProcessInstanceEntity processInstanceEntity) {

      /*  Session session = null;
        boolean flag = false;
        try {
            session = DBUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();

            session.update(processInstanceEntity);

            session.getTransaction().commit();
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //DBUtils.closeSession(session);
        }
        return flag;*/
        return false;
    }


    public ArrayList<ProcessInstanceEntity> findProcessInstanceByProcessName(String processName) {
        return null;
    }

    public ArrayList<ProcessInstanceEntity> findProcessInstance(ProcessInstanceEntity processInstanceEntity) {

      /*  Session session = null;
        ArrayList<ProcessInstanceEntity> processInstanceEntities = null;
        try {
            session = DBUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(ProcessInstanceEntity.class);

            Criterion allCriterion = Restrictions.allEq(processInstanceEntity.getNotNullPropertyMap());

            criteria.add(allCriterion);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            processInstanceEntities = (ArrayList<ProcessInstanceEntity>) criteria.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // DBUtils.closeSession(session);
        }
        return processInstanceEntities;*/
        return null;
    }

    public ProcessInstanceEntity findProcessInstanceByProcessInstanceId(String processInstanceId) {
        return null;
    }

    public boolean deleteProcessInstance(ProcessInstanceEntity processInstanceEntity) {
        return false;
    }

    public ArrayList<ProcessInstanceEntity> getAllProcessInstance() {
       /* Session session = null;
        ArrayList<ProcessInstanceEntity> processInstanceEntities = null;
        try {
            session = DBUtils.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(ProcessInstanceEntity.class);

            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            processInstanceEntities = (ArrayList<ProcessInstanceEntity>) criteria.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // DBUtils.closeSession(session);
        }
        return processInstanceEntities;*/

        return null;
    }
}
