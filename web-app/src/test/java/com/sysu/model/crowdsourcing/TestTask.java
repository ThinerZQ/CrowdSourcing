package com.sysu.model.crowdsourcing;

import com.sysu.model.crowdsourcing.dao.CrowdSourcingTaskDao;
import com.sysu.model.crowdsourcing.dao.UserDao;
import com.sysu.model.crowdsourcing.entity.CrowdSourcingTask;
import com.sysu.model.crowdsourcing.entity.DecomposeTask;
import com.sysu.model.crowdsourcing.entity.DecomposeVoteTask;
import com.sysu.model.crowdsourcing.services.DecomposeTaskService;
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
import java.util.Set;

/**
 * Created by zhengshouzi on 2015/9/20.
 * i love you
 *
 *
 * test again
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

    @Resource
    DecomposeTaskService decomposeTaskService;

    @Test
    public void testPostTask() {
        for (int i = 0; i < 10; i++) {
            CrowdSourcingTask crowdSourcingTask = new CrowdSourcingTask();
            crowdSourcingTask.setTaskName("дһƪ�����ڰ�������  " + i);
            crowdSourcingTask.setTaskDescription("�ڰ���ô1111111111111111");
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

    @Test
    @Transactional
    public void testDecomposeTask() {
        DecomposeTask condDt = new DecomposeTask();
        condDt.setTaskId(3);
        DecomposeTask dt_1 = decomposeTaskService.getDecomposeTask(condDt);

        DecomposeVoteTask dvt = dt_1.getDecomposeVoteTaskSet().iterator().next();

        Set<DecomposeTask> bestDecomposeTasks = dvt.getDecomposeTaskSet();
        System.out.println(bestDecomposeTasks.size());
    }
}
