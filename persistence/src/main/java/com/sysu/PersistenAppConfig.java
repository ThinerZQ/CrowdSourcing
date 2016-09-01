package com.sysu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/8/31
 * Time: 17:16
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
@Configuration
@MapperScan(value = "com.sysu.model")
public class PersistenAppConfig {

    /*@Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager();
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource();
        return sessionFactory.getObject();
    }*/
}
