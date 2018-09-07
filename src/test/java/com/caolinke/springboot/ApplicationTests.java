package com.caolinke.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void testString(){
        List<String> list = new ArrayList<>();
        list.add("篮球");
        list.add("football");
        System.out.println(list.toString());

    }
    @Test
    public void contextLoads() {
    }


}
