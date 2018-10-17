package com.caolinke.test;

import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    public void testStringTrim(){
        String str = "  a b c  ";
        int st = 0;
        int count = str.length();
        char[] chars = str.toCharArray();
        System.out.println(str);
        while(st < count && chars[st] <= ' ') {
            st++;
        }
        while(chars[count-1] <= ' ') {
            count--;
        }
        System.out.println(str.substring(st,count));
    }
}
