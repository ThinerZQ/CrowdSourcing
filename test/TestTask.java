import com.sun.javafx.tk.Toolkit;
import com.zhengshouzi.myweb.dao.DescriptionDao;
import com.zhengshouzi.myweb.dao.JudgeTaskDao;
import com.zhengshouzi.myweb.dao.TaskDao;
import com.zhengshouzi.myweb.dao.UserDao;
import com.zhengshouzi.myweb.entity.DescriptionEntity;
import com.zhengshouzi.myweb.entity.JudgetaskEntity;
import com.zhengshouzi.myweb.entity.TaskEntity;
import com.zhengshouzi.myweb.tools.ConstantDefine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    @Resource(name = "descriptionDao")
    DescriptionDao descriptionDao;

    @Resource(name = "judgeTaskDao")
    JudgeTaskDao judgeTaskDao;

    @Test
    public void testPostTask() {
        for(int i=0;i<10;i++){
            TaskEntity taskEntity = new TaskEntity();
            taskEntity.setTitle("写一篇关于众包的文章  " + i);
            taskEntity.setTaskType("mainTask");
            taskEntity.setUserEntity(userDao.findUserByEmail("601097836@qq.com"));
            taskEntity.setDeadlineTime(new Date());
            taskEntity.setReleaseTime(new Date());
            taskEntity.setPrice("10000");

            for(int j=0;j<3;j++) {
                DescriptionEntity descriptionEntity = new DescriptionEntity();
                descriptionEntity.setDescription("一定要切题  "+j+ "  不少于10000字哦");
                descriptionEntity.setTaskEntity(taskEntity);
                taskEntity.getDescriptionEntitySet().add(descriptionEntity);
            }
            taskDao.addTask(taskEntity);
        }
    }
    @Test
    public void testAddJudgeTask() {

        List<TaskEntity> taskEntityList = taskDao.findAllTask();

        for (int i = 0; i < taskEntityList.size(); i++) {
            for (int j = 0; j < ConstantDefine.JudgeNumber; j++) {
                JudgetaskEntity judgetaskEntity = new JudgetaskEntity();
                judgetaskEntity.setReleaseTime(new Date());
                judgetaskEntity.setUserEntity(userDao.findUserByEmail("admin@admin.com"));
                judgetaskEntity.setTaskEntity(taskEntityList.get(i));
                judgetaskEntity.setPrice("10");
                judgeTaskDao.addJudgeTask(judgetaskEntity);

            }
        }
    }
    @Test
    public void testGetAllTask() {

        List<TaskEntity> taskEntityList = taskDao.findAllTask();

        for (TaskEntity taskEntity :taskEntityList) {

            System.out.println(taskEntity.title);
            for (DescriptionEntity descriptionEntity :taskEntity.getDescriptionEntitySet()){
                System.out.println(descriptionEntity.description);
            }

        }
    }
}
