package com.caolinke.proxy.CGLib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class StudentInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法执行前:"+method.getName());
        Object invokeSuper = methodProxy.invokeSuper(o, objects);
        System.out.println("方法执行后:"+method.getName());
        return invokeSuper;
    }
}
