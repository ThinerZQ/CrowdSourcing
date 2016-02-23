package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.DecomposeTaskDao;
import com.sysu.crowdsourcing.entity.DecomposeTask;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/15
 * Time: 13:31
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class DecomposeTaskDaoImpl implements DecomposeTaskDao {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;


    @Transactional
    public long saveDecomposeTask(DecomposeTask decomposeTask) {
        long id = -1;
        try {
            Session session = sessionFactory.getCurrentSession();

            id = (Long) session.save(decomposeTask);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            return id;
        }
    }

    @Transactional
    public boolean saveDecomposeTask(ArrayList<DecomposeTask> decomposeTasks) {

        long id = -1;
        boolean flag = true;
        for (DecomposeTask decomposeTask : decomposeTasks) {
            id = -1;
            try {
                Session session = sessionFactory.getCurrentSession();

                id = (Long) session.save(decomposeTask);

            } catch (HibernateException e) {
                e.printStackTrace();
            } finally {
                if (id == -1) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    @Transactional
    public ArrayList<DecomposeTask> getDecomposeTasks(DecomposeTask decomposeTask) {

        ArrayList<DecomposeTask> decomposeTaskArrayList = new ArrayList<DecomposeTask>();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(DecomposeTask.class);

            Criterion allCriterion = Restrictions.allEq(decomposeTask.getNotNullPropertyMap());

            criteria.add(allCriterion);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            decomposeTaskArrayList = (ArrayList<DecomposeTask>) criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decomposeTaskArrayList;
    }

    public DecomposeTask getDecomposeTask(DecomposeTask decomposeTask) {
        DecomposeTask dt = new DecomposeTask();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(DecomposeTask.class);

            Criterion allCriterion = Restrictions.allEq(decomposeTask.getNotNullPropertyMap());

            criteria.add(allCriterion);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            dt = (DecomposeTask) criteria.list().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dt;
    }
}
