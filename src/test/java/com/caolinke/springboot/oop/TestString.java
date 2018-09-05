package com.caolinke.springboot.oop;

import org.junit.Test;

public class TestString {

    @Test
    public void testIntern(){
        String s1 = new String("abc");
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s1 == s2.intern()); //false
        System.out.println(s3 == s2.intern()); //false
        System.out.println(s1 == s3.intern()); //false
        System.out.println(s3 == s3.intern());

    }
}
