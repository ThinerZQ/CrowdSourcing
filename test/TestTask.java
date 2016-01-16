import com.sysu.crowdsourcing.dao.TaskDao;
import com.sysu.crowdsourcing.dao.UserDao;
import com.sysu.crowdsourcing.entity.TaskEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration
public class TestTask extends AbstractJUnit4SpringContextTests {

    @Resource(name = "userDao")
    UserDao userDao;
    @Resource(name = "taskDao")
    TaskDao taskDao;


    @Test
    public void testPostTask() {
        for (int i = 0; i < 10; i++) {
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTaskName("写一篇关于众包的文章  " + i);
            taskEntity.setTaskDescription("众包怎么1111111111111111");
            taskEntity.setTaskType("mainTask");
            taskEntity.setUserEntity(userDao.findUserByEmail("601097836@qq.com"));
            taskEntity.setTaskDeadlineTime(new Date());
            taskEntity.setTaskReleaseTime(new Date());
            taskEntity.setTaskPrice("10000");
            taskDao.addTask(taskEntity);
        }
    }

    @Test
    public void testAddJudgeTask() {


    }

    @Test
    public void testGetAllTask() {

        List<TaskEntity> taskEntityList = taskDao.findAllTask();


    }
}
