package com.ys.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// @Aspect表示这个类是一个切面类
@Aspect()
//表示存在多个切面时它的优先级，默认是integer的最大值,越小优先级越高,越先运行
@Order(value = 1)
// @Component注解保证这个切面类能够放入IOC容器
@Component
public class LogAspect {
    //重用切入表到时
    @Pointcut("execution(* com.ys.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut(){}

    //前置通知：使用@Before注解标识，在被代理的目标方法前执行
    @Before("pointCut()")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->前置通知，方法名："+methodName+"，参数："+args);
    }
    //返回通知：使用@AfterReturning注解标识，在被代理的目标方法成功结束后执行（寿终正寝）
    @AfterReturning(value = "execution(* com.ys.spring.aop.annotation.CalculatorImpl.*(..))",returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint,Object result){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->返回通知，方法名："+methodName+"，结果："+result);
    }
    //异常通知：使用@AfterThrowing注解标识，在被代理的目标方法异常结束后执行（死于非命）
    @AfterThrowing(value = "execution(* com.ys.spring.aop.annotation.CalculatorImpl.*(..))",throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint,Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger-->异常通知，方法名："+methodName+"，出现异常："+ex);
    }
    //后置通知：使用@After注解标识，在被代理的目标方法最终结束后执行（盖棺定论）
    @After(value="pointCut()" )
    public void afterMethod(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().getName();
        System.out.println("Logger-->后置通知，方法名："+methodName+"，运行结束");
    }
    //环绕通知：使用@Around注解标识，使用try...catch...finally结构围绕整个被代理的目标方法，包
    //括上面四种通知对应的所有位置
    @Around(value = "pointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕->前置通知");
            //目标方法执行
            result= joinPoint.proceed();
            System.out.println("环绕->返回后通知");
        }catch (Throwable e) {
            System.out.println("环绕->异常通知");
            e.printStackTrace();
        }finally {
            System.out.println("环绕->后置通知");
        }
        return result;
    }
}
