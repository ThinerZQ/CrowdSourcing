import com.sysu.crowdsourcing.dao.DescriptionDao;
import com.sysu.crowdsourcing.dao.TaskDao;
import com.sysu.crowdsourcing.dao.UserDao;
import com.sysu.crowdsourcing.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration
public class TestUser extends AbstractJUnit4SpringContextTests {

    @Resource(name = "userDao")
    UserDao userDao;
    @Resource(name = "taskDao")
    TaskDao taskDao;
    @Resource(name = "descriptionDao")
    DescriptionDao descriptionDao;

    @Test
    public void testCheckUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("601097836@qq.com");
        userEntity.setPassword("zhengqiang");


        System.out.println(userDao.checkUser(userEntity));
    }
    @Test
    public void testAddUser1() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("admin@admin.com");
        userEntity.setPassword("admin");
        userDao.addUser(userEntity);
    }
    @Test
    public void testAddUser2() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("Q.Zheng");
        userEntity.setEmail("601097836@qq.com");
        userEntity.setPassword("zhengqiang");
        userEntity.setStatus(String.valueOf(1));
        userEntity.setRegisterDate(new Date());
        userEntity.setActivateCode("224124safagd");
        userDao.addUser(userEntity);
    }
}
