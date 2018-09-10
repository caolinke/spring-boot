package com.caolinke.proxy.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * java动态代理，需要实现InvocationHandler接口
 */
public class TeacherPeoxy implements InvocationHandler {
    private Object object;
    /*public TeacherPeoxy(Object o) {
        this.object = o;
    }*/
    public Object getInstance(Object o){
        this.object = o;
        Class clazz = this.object.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("执行代理方法");
        method.invoke(object,args);
        System.out.println("执行方法之后");
        return null;
    }
}
