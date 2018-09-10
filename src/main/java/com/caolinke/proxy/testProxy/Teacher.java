package com.caolinke.proxy.testProxy;

public class Teacher implements Person {
    @Override
    public String getName(String name) {
        System.out.println("theacher:" + name);
        return name;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("你好："+name);
        return name+"老师好";
    }
}
