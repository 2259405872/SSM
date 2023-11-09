package com.ys.spring;

import com.ys.spring.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBeanScope {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("bean_scope.xml");
        User bean = ioc.getBean(User.class);
        User bean1 = ioc.getBean(User.class);
        System.out.println(bean1==bean);//false 因为bean的scope属性为prototype
    }
}
