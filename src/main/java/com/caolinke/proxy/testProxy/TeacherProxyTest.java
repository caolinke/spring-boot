package com.caolinke.proxy.testProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * java 动态代理
 */
public class TeacherProxyTest {
    public static void main(String[] args) {
//        Person person = new Teacher();
//        TeacherPeoxy teacherPeoxy = new TeacherPeoxy(person);
//        Person instance = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), teacherPeoxy);
//        instance.getName("李老师");
//        instance.sayHello("张老师");
        TeacherPeoxy teacherPeoxy = new TeacherPeoxy();
        Person person = (Person) teacherPeoxy.getInstance(new Teacher());
        person.getName("王老五");
        person.sayHello("王老师");
    }
}
