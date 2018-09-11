package com.caolinke.proxy.test;

import com.caolinke.proxy.testProxy.Person;
import com.caolinke.proxy.testProxy.Student;

public class JTest {
    public static void main(String[] args) {
        Person person = new Student();
        JHandler jHandler = new JHandler();
        Person instance = (Person) jHandler.getInstance(person);
        instance.getName("令狐冲");
        instance.sayHello("令狐冲");
    }
}
