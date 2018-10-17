package com.caolinke.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 开启aop注解扫描
 * @Configuration  配置类
 * @EnableAspectJAutoProxy 开启spring对aop的支持
 * @ComponentScan("com.caolinke.aop") 扫描该目录下所有的bean
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.caolinke.aop")
public class AopConfig {
}
