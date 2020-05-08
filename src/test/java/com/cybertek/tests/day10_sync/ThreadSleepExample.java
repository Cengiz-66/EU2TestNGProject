package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThreadSleepExample {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
       driver= WebDriverFactory.getDriver("chrome");
       driver.manage().window().maximize();
    }

    @AfterMethod
    public void closeSetUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/3");

        Thread.sleep(7000);
        driver.findElement(By.id("username")).sendKeys("Mike Smith");

    }
}
