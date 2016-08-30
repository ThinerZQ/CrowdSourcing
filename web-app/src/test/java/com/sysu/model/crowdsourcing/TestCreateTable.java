package com.sysu.model.crowdsourcing;

import com.sysu.model.crowdsourcing.dao.UserDao;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;

/**
 * Created by zhengshouzi on 2015/9/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration
public class TestCreateTable extends AbstractJUnit4SpringContextTests {

    @Resource(name = "userDao")
    UserDao userDao;

    @Test
    public void testCreateTable() {

        Configuration config = new Configuration().configure();
        SchemaExport schema = new SchemaExport(config);
        schema.setFormat(true).create(true, true);

    }


}
