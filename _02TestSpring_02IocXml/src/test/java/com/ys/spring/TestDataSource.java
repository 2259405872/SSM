package com.ys.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class TestDataSource {
    @Test
    public void testDataSource() throws SQLException {
        ApplicationContext ac = new ClassPathXmlApplicationContext("data_source.xml");
        DataSource dataSource = ac.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

}
