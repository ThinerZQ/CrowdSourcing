package com.sysu.workflow;

import com.sysu.workflow.service.identityservice.IdentityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/1/22
 * Time: 17:12
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://blog.csdn.net/c601097836</a>
 * Email: 601097836@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration
public class TestIdentityService extends AbstractJUnit4SpringContextTests {

    @Resource(name = "identityService")
    IdentityService identityService;

    @Before
    public void before() {

    }

    @Test
    public void testFindTask() {
    /*    UserEntity userEntity = IdentityService.createUserQuery().userRealName("judger1").SingleResult();

        System.out.println(userEntity.toString());*/
    }
}
