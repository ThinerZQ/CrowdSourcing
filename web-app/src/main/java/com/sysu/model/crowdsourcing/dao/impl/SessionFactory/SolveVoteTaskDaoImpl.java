package com.sysu.model.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.model.crowdsourcing.dao.SolveVoteTaskDao;
import com.sysu.model.crowdsourcing.entity.SolveVoteTask;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/25
 * Time: 19:06
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class SolveVoteTaskDaoImpl implements SolveVoteTaskDao {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Transactional
    public long saveSolveVoteTask(SolveVoteTask solveVoteTask) {
        long id = -1;
        try {
            Session session = sessionFactory.getCurrentSession();

            session.merge(solveVoteTask);
            id = 0;
        } catch (HibernateException e) {
            e.printStackTrace();
            id = -1;
        } finally {
            return id;
        }
    }

    @Transactional
    public SolveVoteTask getSolveVoteTask(SolveVoteTask solveVoteTask) {
        SolveVoteTask solveVoteTask1 = null;
        try {
            Session session = sessionFactory.getCurrentSession();
            Criteria criteria = session.createCriteria(SolveVoteTask.class);

            Criterion allCriterion = Restrictions.allEq(solveVoteTask.getNotNullPropertyMap());

            criteria.add(allCriterion);
            criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

            solveVoteTask1 = (SolveVoteTask) criteria.list().get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return solveVoteTask1;
    }
}
