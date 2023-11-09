package com.ys.spring;

import com.ys.spring.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactory {
    @Test
    public void testUserFactoryBean(){
//获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("factory.xml");
        User user = (User) ac.getBean("user");
        System.out.println(user);
    }
}
