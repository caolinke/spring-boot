package com.caolinke.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 使用AnnotationConfigApplicationContext可以实现基于Java的配置类加载Spring的应用上下文
 * 通过上下文获取spring中的bean
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AopService bean = context.getBean(AopService.class);
        bean.watchMovie();
    }
}
