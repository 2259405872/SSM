package test;

import com.ys.spring.aop.annotation.Calculator;
import com.ys.spring.aop.annotation.CalculatorImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void testAnnotationAop(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //这里因为CalculatorImpl有aop切面，被代理，添加了通知。所以就不能生成实例了，可以通过他继承的接口生成CalculatorImpl的代理类实例
        Calculator bean = ioc.getBean(Calculator.class);
        System.out.println(bean.getClass());
        int div = bean.div(1,1);
    }

    @org.junit.Test
    public void testAnnotationAop1(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //这里因为CalculatorImpl有aop切面，被代理，添加了通知。所以就不能生成实例了，可以通过他继承的接口生成CalculatorImpl的代理类实例
        Calculator bean = ioc.getBean(Calculator.class);
        System.out.println(bean.getClass());
        int div = bean.div(1,1);
    }
}
