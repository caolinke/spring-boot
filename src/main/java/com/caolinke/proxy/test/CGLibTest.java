package com.caolinke.proxy.test;

import com.caolinke.proxy.testProxy.Person;
import com.caolinke.proxy.testProxy.Teacher;
import org.springframework.cglib.proxy.Enhancer;

public class CGLibTest {
    public static void main(String[] args) {
        /**
         *  cglib通过enhancer类进行操作
         *  enhancer.setSuperclass(Teacher.class);设置需要增强的类
         *  enhancer.setCallback(new CGLibHandler());设置回调函数，也即是代理类
         *  enhancer.create();生成代理对象，通过生成的代理对象执行相应的方法
         */
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Teacher.class);
        enhancer.setCallback(new CGLibHandler());
        Person teacher = (Person) enhancer.create();
        teacher.getName("王老师");
        teacher.sayHello("王老师");
    }
}
