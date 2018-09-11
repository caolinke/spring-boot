package com.caolinke.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JHandler implements InvocationHandler {
    private Object object;

    public Object getInstance(Object o){
        this.object = o;
        Class instance = object.getClass();
        return Proxy.newProxyInstance(instance.getClassLoader(),instance.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在这里执行方法
        long l = System.currentTimeMillis();
        System.out.println("当前时间是："+l);
        method.invoke(object,args);
        long end = System.currentTimeMillis();
        System.out.println("结束时间是："+end);
        return null;
    }
}
