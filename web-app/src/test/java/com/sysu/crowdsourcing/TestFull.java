package com.sysu.crowdsourcing;

import com.sysu.crowdsourcing.service.*;
import com.sysu.model.crowdsourcing.CrowdSourcingTaskEntity;
import com.sysu.model.workflow.UserEntity;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/2/23
 * Time: 14:09
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration
public class TestFull {

    @Resource
    LoginService loginService;
    @Resource
    PostService postService;
    @Resource
    CrowdSourcingTaskService crowdSourcingTaskService;
    @Resource
    JudgeTaskService judgeTaskService;
    @Resource
    DecomposeTaskService decomposeTaskService;
    @Resource
    DecomposeVoteTaskService decomposeVoteTaskService;

    public void testFull() {

        UserEntity userEntity = loginService.getUserByEmail("poster@qq.com");

        CrowdSourcingTaskEntity crowdSourcingTaskEntity = new CrowdSourcingTaskEntity();
        crowdSourcingTaskEntity.setTaskName("testTask");
        crowdSourcingTaskEntity.setTaskDescription("testDescription");
        //crowdSourcingTaskEntity.setTaskReleaseTime(new Date());
        crowdSourcingTaskEntity.setTaskDeadlineTime(new Date());
        //crowdSourcingTaskEntity.setUserEntity(userEntity);


        boolean flag = postService.postTask(crowdSourcingTaskEntity);

        if (flag) {

            UserEntity judger1 = loginService.getUserByEmail("judger1@qq.com");

        }
    }
}
