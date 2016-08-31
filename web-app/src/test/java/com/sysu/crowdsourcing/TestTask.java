package com.sysu.crowdsourcing;

import com.sysu.crowdsourcing.service.CrowdSourcingTaskService;
import com.sysu.crowdsourcing.service.DecomposeTaskService;
import com.sysu.model.crowdsourcing.CrowdSourcingTaskEntity;
import com.sysu.model.crowdsourcing.DecomposeTaskEntity;
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
 * i love you
 *
 *
 * test again
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration
public class TestTask extends AbstractJUnit4SpringContextTests {


    @Resource
    CrowdSourcingTaskService crowdSourcingTaskService;

    @Resource
    DecomposeTaskService decomposeTaskService;

    @Test
    public void testPostTask() {
        for (int i = 0; i < 10; i++) {
            CrowdSourcingTaskEntity crowdSourcingTaskEntity = new CrowdSourcingTaskEntity();
            crowdSourcingTaskEntity.setTaskName("  " + i);
            crowdSourcingTaskEntity.setTaskDescription("");
            crowdSourcingTaskEntity.setTaskType("mainTask");
            //crowdSourcingTaskEntity.setUserEntity(userDao.findUserByEmail("601097836@qq.com"));
            crowdSourcingTaskEntity.setTaskDeadlineTime(new Date());
            //crowdSourcingTaskEntity.setTaskReleaseTime(new Date());
            crowdSourcingTaskEntity.setTaskPrice("10000");
            //crowdSourcingTaskDao.addTask(crowdSourcingTaskEntity);
        }
    }

    @Test
    @Transactional
    public void testGetCrowdSourcingTask() {
        /*//ProcessInstanceEntity processInstanceEntity = RuntimeService.createProcessInstanceQuery().processInstanceId("10").SingleResult();
        CrowdSourcingTaskEntity crowdSourcingTask = new CrowdSourcingTaskEntity();
       // crowdSourcingTask.setProcessInstanceEntity(processInstanceEntity);
        List<CrowdSourcingTaskEntity> task =crowdSourcingTaskDao.getCrowdSourcingTask(crowdSourcingTask);*/
        //crowdSourcingTaskDao.getCrowdSourcingTaskByProcessInstanceId(10);
        // System.out.println(task.size());
    }

    @Test
    @Transactional
    public void testDecomposeTask() {
        DecomposeTaskEntity condDt = new DecomposeTaskEntity();
        condDt.setTaskId(3);
        DecomposeTaskEntity dt_1 = decomposeTaskService.getDecomposeTask(condDt);

        //DecomposeVoteTaskEntity dvt = dt_1.getDecomposeVoteTaskSet().iterator().next();

        //Set<DecomposeTaskEntity> bestDecomposeTasks = dvt.getDecomposeTaskSet();
        //System.out.println(bestDecomposeTasks.size());
    }
}
