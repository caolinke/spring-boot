package com.caolinke.proxy.test;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib 实现MethodInterceptor 过滤器
 */
public class CGLibHandler implements MethodInterceptor {
    /**
     *
     * @param o             需要增强的对象
     * @param method        获得具体执行的某个方法
     * @param objects       方法参数
     * @param methodProxy   执行代理方法
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //执行方法
        System.out.println("方法执行前："+System.currentTimeMillis());
        System.out.println(o.getClass().getName());
        System.out.println(method.getName());
        System.out.println(objects[0].toString());
        System.out.println(methodProxy.getSuperName());
        methodProxy.invokeSuper(o,objects);
        System.out.println("方法执行后："+System.currentTimeMillis());
        return null;
    }
}
