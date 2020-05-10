package com.cybertek.tests.day1_intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxNavigation {
    public static void main(String[] args) {
      //  System.setProperty("webdriver.gecko.driver","D:\\aa\\drivers\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Mozilla Firefox\\browser\\geckodriver.exe");

        WebDriver driver=new FirefoxDriver();

        driver.manage().window().maximize();
        driver.get("https://google.com");
        System.out.println("Title: "+driver.getTitle());
        System.out.println("Url: "+driver.getCurrentUrl());
    }


}
