package com.cybertek.tests.day7_testng;

import org.testng.annotations.*;

public class BeforeAfterTests {

    @Test
    public void test1(){
        System.out.println("This is my test 1");
    }

    @Test
    public void test2(){
        System.out.println("This is my test 2");
    }

    @BeforeMethod
    public void setUp() {
        //WebDriver part
        System.out.println("Before method here");
        System.out.println("WebDriver part");
    }

    @AfterMethod
    public void tearDown() {
        //driver quit
        System.out.println("After method here");
        System.out.println("driver quit");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("--BEFORE CLASS");
        System.out.println("Runs only once before everything");
    }

    @AfterClass
    public void tearDownClass() {
        System.out.println("--AFTER CLASS--");
        System.out.println("Runs only once after everything");
    }


}
