package com.caolinke.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 定义一个切面类
 */
@Aspect
@Component
public class TestAop {

    @Pointcut("execution(* com.caolinke.aop.AopService.*(..))")
    public void action(){}

    @Before("action()")
    public void before(){
        System.out.println("我是前置通知");
        System.out.println("看电影之前需要买票啊");
    }

    @After("action()")
    public void after(){
        System.out.println("我是后置通知");
        System.out.println("电影真的很精彩呀");
    }

    @Around("action()")
    public void around(ProceedingJoinPoint pj){
        System.out.println("环绕通知啊");
        System.out.println("环绕通知前");
        try {
            pj.proceed();
        } catch (Throwable throwable) {
            System.out.println("出错了");
        }
        System.out.println("环绕通知后");

    }
}
