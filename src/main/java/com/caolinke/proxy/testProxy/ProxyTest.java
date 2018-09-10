package com.caolinke.proxy.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 定义动态代理类，代理类实现InvocationHandler接口
 */
public class ProxyTest implements InvocationHandler {
    //要代理的真实对象
    private Object person;
    public ProxyTest (Object object){
        this.person = object;
    }

    /**
     * 代理对象
     * @param proxy    表示代理者，
     * @param method    被执行的方法
     * @param args      被执行方法所需要的参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //把所有额外追加的操作写在该方法里面
        System.out.println("方法执行之前");
        System.out.println(proxy.getClass().getName());
        method.invoke(person,args);
        System.out.println("方法执行之后");
        return null;
    }
}
