package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalismaAlert {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void testAlert() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //locate click the for JS alert button
        driver.findElement(By.xpath("//button[1]")).click();

        //Alert class coming from selenium class*****
        Alert alert=driver.switchTo().alert();
        //click OK button on alert
        alert.accept();
        Thread.sleep(2000);
        //locate click the for JS confirm button
        driver.findElement(By.xpath("//button[2]")).click();
        //Click the cancel button
        alert.dismiss();
        Thread.sleep(2000);
        //locate click the for JS Prompt button
        driver.findElement(By.xpath("//button[3]")).click();
        //sendkeys to alert and click OK
        alert.sendKeys("Hello World");
        alert.accept();
        Thread.sleep(4000);

//I make a change here*********


    }
}
