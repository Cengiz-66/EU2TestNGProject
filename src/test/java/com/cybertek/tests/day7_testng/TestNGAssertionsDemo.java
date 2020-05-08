package com.cybertek.tests.day7_testng;

import org.testng.*;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {
    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals("title","Title","checking the title");

        System.out.println("Second Assertion");
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2(){
        System.out.println("second test case");
        Assert.assertEquals("url","url");

    }

    @Test
    public void test3(){
        String exp="Cybt";
        String act="Cybertek"; //verify that your title starts with Cyb

        Assert.assertTrue(act.startsWith(exp),"checking the title if starts with Cyb");
    }

    @Test
    public void test4(){
        //verify that email contains @
        String email="mike@smith.com";

        Assert.assertTrue(email.contains("@"),"verify that email contain @ sign");
    }

    @Test
    public void test5(){
        //verify that somthing is false

        Assert.assertNotEquals("one","one","verify that if they are equals");
    }
}
