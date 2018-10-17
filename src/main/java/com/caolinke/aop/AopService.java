package com.caolinke.aop;

import org.springframework.stereotype.Service;

@Service
public class AopService {


    public void  watchMovie(){
        System.out.println("我在看电影");
    }
}
