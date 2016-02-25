package com.sysu.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.crowdsourcing.dao.SolveTaskDao;
import com.sysu.crowdsourcing.entity.SolveTask;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/25
 * Time: 11:06
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SolveTaskDaoImpl implements SolveTaskDao {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Transactional
    public long saveSolveVote(SolveTask solveTask) {
        long id = -1;
        try {
            Session session = sessionFactory.getCurrentSession();

            id = (Long) session.save(solveTask);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            return id;
        }
    }

    @Transactional
    public SolveTask getSolveTask(SolveTask solveTask) {
        SolveTask st = new SolveTask();
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(SolveTask.class);

            Criterion allCriterion = Restrictions.allEq(solveTask.getNotNullPropertyMap());

            criteria.add(allCriterion);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            st = (SolveTask) criteria.list().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }

    @Transactional
    public List<SolveTask> getSolveTasks(SolveTask solveTask) {
        return null;
    }

    @Transactional
    public boolean updateSolveTask(SolveTask solveTask) {
        boolean flag = false;
        try {
            Session session = sessionFactory.getCurrentSession();
            session.update(solveTask);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }
}
