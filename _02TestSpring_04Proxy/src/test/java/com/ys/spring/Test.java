package com.ys.spring;

import com.ys.spring.proxy.Calculator;
import com.ys.spring.proxy.CalculatorImpl;
import com.ys.spring.proxy.ProxyFactory;

public class Test {
    @org.junit.Test
    public void test(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator)proxyFactory.getProxy();
        int add = proxy.add(1, 1);
    }
}
