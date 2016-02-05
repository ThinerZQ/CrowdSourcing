package com.sysu.crowdsourcing;

import com.sysu.crowdsourcing.dao.CrowdSourcingTaskDao;
import com.sysu.crowdsourcing.dao.UserDao;
import com.sysu.crowdsourcing.entity.CrowdSourcingTask;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration
public class TestTask extends AbstractJUnit4SpringContextTests {

    @Resource(name = "sessionFactory")
    public SessionFactory sessionFactory;
    @Resource(name = "userDao")
    UserDao userDao;
    @Resource(name = "crowdSourcingTaskDao")
    CrowdSourcingTaskDao crowdSourcingTaskDao;

    @Test
    public void testPostTask() {
        for (int i = 0; i < 10; i++) {
            CrowdSourcingTask crowdSourcingTask = new CrowdSourcingTask();
            crowdSourcingTask.setTaskName("写一篇关于众包的文章  " + i);
            crowdSourcingTask.setTaskDescription("众包怎么1111111111111111");
            crowdSourcingTask.setTaskType("mainTask");
            crowdSourcingTask.setUserEntity(userDao.findUserByEmail("601097836@qq.com"));
            crowdSourcingTask.setTaskDeadlineTime(new Date());
            crowdSourcingTask.setTaskReleaseTime(new Date());
            crowdSourcingTask.setTaskPrice("10000");
            crowdSourcingTaskDao.addTask(crowdSourcingTask);
        }
    }

    @Test
    @Transactional
    public void testGetCrowdSourcingTask() {
        /*//ProcessInstanceEntity processInstanceEntity = RuntimeService.createProcessInstanceQuery().processInstanceId("10").SingleResult();
        CrowdSourcingTask crowdSourcingTask = new CrowdSourcingTask();
       // crowdSourcingTask.setProcessInstanceEntity(processInstanceEntity);
        List<CrowdSourcingTask> task =crowdSourcingTaskDao.getCrowdSourcingTask(crowdSourcingTask);*/
        crowdSourcingTaskDao.getCrowdSourcingTaskByProcessInstanceId(10);
        // System.out.println(task.size());
    }
}
