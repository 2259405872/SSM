package com.ys.spring;

import com.ys.spring.controller.UserController;
import com.ys.spring.controller.impl.UserControllerImpl;
import com.ys.spring.dao.UserDao;
import com.ys.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Tset {
    @Test
    public void testAnnotation(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = ac.getBean(UserController.class);
        System.out.println(userController);
        UserService userService = ac.getBean(UserService.class);
        System.out.println(userService);
        UserDao userDao = ac.getBean(UserDao.class);
        System.out.println(userDao);

    }


/*
    @Autowired中有属性required，默认值为true，因此在自动装配无法找到相应的bean时，会装
            配失败
    可以将属性required的值设置为true，则表示能装就装，装不上就不装，此时自动装配的属性为
            默认值
    但是实际开发时，基本上所有需要装配组件的地方都是必须装配的，用不上这个属性。
*/

    @Test
    public void testAutoWise(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserController userController = ac.getBean(UserController.class);
        System.out.println(userController);
    }
}
