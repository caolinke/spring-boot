package com.caolinke.proxy.testProxy;

/**
 * 实现接口
 */
public class Student implements Person {
    @Override
    public String getName(String name) {
        System.out.println("Student name is : "+name);
        return "Student name is : "+name;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("hello :" + name);
        return "hello :" + name;
    }
}
