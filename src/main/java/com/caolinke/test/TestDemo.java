package com.caolinke.test;

import org.apache.tomcat.util.digester.ArrayStack;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TestDemo {

    @Test
    public void test1() {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        System.out.println(ary.length);
    }
    @Test
    public void testListToArray(){
        List<String> list = new ArrayList<String>();
        list.add("ni");
        list.add("hao");
        list.add("ya");
        System.out.println(list.size());

        String[] ary = new String[list.size()];
        ary = list.toArray(ary);
        System.out.println(ary.length);
        for (String str: ary) {
            System.out.println(str);
        }
    }
    @Test
    public void testArrayToList(){
        String[] array = new String[] {"ni","wo"};
        array[0] = "ta";
        List<String> list = Arrays.asList(array);
        //asList返回的对象是Arrays中的一个内部类，并没有实现集合的修改方法，后台的数据仍然是数组，
        // 所以下面代码回报运行时异常
        //list.add("ta");
        for (String str : list) {
            System.out.println(str);
        }
    }
    @Test
    public void testListRemove(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        for(int i = 0; i < list.size(); i++) {
            if("2".equals(list.get(i))) {
                list.remove(i);
            }
        }
        System.out.println(list.size());
        for (String str : list) {
            System.out.println(str);
        }
    }
    @Test
    public void testMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age",17);
        map.put("gender","男");
        map.put("addr","西城区灵境胡同");

        map.forEach((k,v) -> System.out.println("key: "+k+" value："+v));
    }
    @Test
    public void testRemove(){
        List<String> list = new ArrayList<>();
        list.add("jack");
        list.add("school");
        list.add("fuck");
        if(list.contains("fuck")){
            boolean b = list.remove("fuc1k");
            System.out.println(b);
        }
        for(String str : list){
            System.out.println(str);
        }
    }
}
