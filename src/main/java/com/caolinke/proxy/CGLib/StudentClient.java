package com.caolinke.proxy.CGLib;

import com.caolinke.proxy.testProxy.Person;
import com.caolinke.proxy.testProxy.Student;
import org.springframework.cglib.proxy.Enhancer;

public class StudentClient {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();     //用于生成代理对象，它是CGLib的字节码增强器
        enhancer.setSuperclass(Student.class); //设置需要增强的类，即设置代理类
        enhancer.setCallback(new StudentInterceptor()); //设置回调
        Person person = (Person) enhancer.create();     //生成代理对象
        person.getName("王二");
        person.sayHello("李教授");
    }
}
