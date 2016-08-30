package com.sysu.model.crowdsourcing.dao.impl.SessionFactory;

import com.sysu.model.crowdsourcing.dao.JudgeTaskDao;
import com.sysu.model.crowdsourcing.entity.JudgeTask;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/15
 * Time: 13:31
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

public class JudgeTaskDaoImpl implements JudgeTaskDao {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;

    @Transactional
    public long saveJudgeTask(JudgeTask judgeTask) {
        long id = -1;
        try {
            Session session = sessionFactory.getCurrentSession();

            id = (Long) session.save(judgeTask);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            return id;
        }
    }
}
