package com.ys.spring.pojo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void testHello(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorld = (HelloWorld)ac.getBean("helloWorld");
        helloWorld.sayHello();
    }

    /*
    ①方式一：根据id获取
        由于 id 属性指定了 bean 的唯一标识，所以根据 bean 标签的 id 属性可以精确获取到一个组件对象。
    上个实验中我们使用的就是这种方式。
    ②方式二：根据类型获取
    ③方式三：根据id和类型
    ④注意
        当根据类型获取bean时，要求IOC容器中指定类型的bean有且只能有一个
        如果组件类实现了接口，根据接口类型可以获取bean,前提是bean唯一
    ⑥结论
        根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：
        『对象 instanceof 指定的类型』的返回结果，只要返回的是true就可以认定为和类型匹配，能够获取到。
    */
    @org.junit.Test
    public void TestGetBean(){
        //①方式一：根据id获取
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld helloWorld = (HelloWorld)ac.getBean("helloWorld");
        helloWorld.sayHello();
        //②方式二：根据类型获取
        //HelloWorld helloWorld1 = ac.getBean(HelloWorld.class);//这样会报错因为配置了两个HelloWorld的bean
        //③方式三：根据id和类型
        HelloWorld helloWorld1 = ac.getBean("helloWorld1", HelloWorld.class);
        helloWorld1.sayHello();
    }
}
