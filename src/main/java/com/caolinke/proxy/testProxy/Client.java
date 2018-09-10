package com.caolinke.proxy.testProxy;



import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 执行代理类
 */
public class Client {
    public static void main(String[] args) {
        //要代理的真实对象
        Person person = new Student();
        //将真实对象作为参数传入到代理对象中
        InvocationHandler handler = new ProxyTest(person);
        Person per = (Person) Proxy.newProxyInstance(handler.getClass().getClassLoader(),person.getClass().getInterfaces(),handler);
        System.out.println(per.getClass().getName());
        per.getName("张三");
        per.sayHello("张三");
    }

}
