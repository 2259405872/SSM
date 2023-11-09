package com.ys.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
@Aspect
@Order(value = 2)
public class LogAspect2 {
    @Pointcut("execution(* com.ys.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}
    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        System.out.println("logAspect2-------------------------------->");
    }
}
