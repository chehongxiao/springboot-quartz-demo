package com.example.springbootquartzdemo;

import com.alibaba.druid.pool.DruidDataSource;
import com.example.springbootquartzdemo.entity.AppQuartz;
import com.example.springbootquartzdemo.service.IAppQuartzService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootQuartzDemoApplicationTests {

    /**
     * Spring Boot 默认已经配置好了数据源(class com.zaxxer.hikari.HikariDataSource)，程序员可以直接 DI 注入然后使用即可
     */
    @Resource
    DataSource dataSource;

    @Autowired
    IAppQuartzService appQuartzService;

    @Test
    public void contextLoads() throws SQLException {
        System.out.println("数据源>>>>>>" + dataSource.getClass());
        Connection connection = dataSource.getConnection();

        System.out.println("连接>>>>>>>>>" + connection);
        System.out.println("连接地址>>>>>" + connection.getMetaData().getURL());

        DruidDataSource druidDataSource = (DruidDataSource) dataSource;
        System.out.println("druidDataSource 数据源最大连接数：" + druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" + druidDataSource.getInitialSize());

        connection.close();

    }

    @Test
    public void testService(){
        AppQuartz appQuartz = new AppQuartz();
        appQuartz.setJobName("job1");
        appQuartz.setCronExpression("0 0 0");
        appQuartz.setJobGroup("group1");
        appQuartz.setInvokeParam("param");
        appQuartz.setStartTime("2019-08-15");
        appQuartzService.insertAppQuartzSer(appQuartz);
    }

}
