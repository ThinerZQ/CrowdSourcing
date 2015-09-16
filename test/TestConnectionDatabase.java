import com.zhengshouzi.myweb.tools.DBHelper;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by zhengshouzi on 2015/9/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TestConnectionDatabase implements ApplicationContextAware{


    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testConnection(){

        DBHelper dbHelper = (DBHelper) applicationContext.getBean("dbHelper");

        System.out.printf(dbHelper.toString());

    }
}
