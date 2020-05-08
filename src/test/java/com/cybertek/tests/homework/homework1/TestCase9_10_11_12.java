package com.cybertek.tests.homework.homework1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TestCase9_10_11_12 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test9() throws InterruptedException {
        //Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. And click on “Status Codes”.
        driver.findElement(By.linkText("Status Codes")).click();
        //Step 3. Then click on “200”.
        driver.findElement(By.linkText("200")).click();
        //Step 4. Verify that following message is displayed:“This page returned a 200 status code”
        WebElement msg = driver.findElement(By.xpath("//*[contains(text(),'200 status code')]"));
        String str=msg.getAttribute("innerHTML").trim();
        String[] s = str.split("<br>");
        String actualMsg=s[0];
        String expectedMsg="This page returned a 200 status code.";
        Assert.assertEquals(actualMsg,expectedMsg,"Verify that following message is displayed:This page returned a 200 status code");

    }

    @Test
    public void test10() throws InterruptedException {
        //Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. And click on “Status Codes”.
        driver.findElement(By.linkText("Status Codes")).click();
        //Step 3. Then click on “301”.
        driver.findElement(By.linkText("301")).click();
        //Step 4. Verify that following message is displayed:"This page returned a 301 status code"
        WebElement msg = driver.findElement(By.xpath("//*[contains(text(),'301 status code')]"));
        Assert.assertTrue(msg.isDisplayed(), "Verify that following message is displayed:This page returned a 301 status code");

    }

    @Test
    public void test11() throws InterruptedException {
        //Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. And click on “Status Codes”.
        driver.findElement(By.linkText("Status Codes")).click();
        //Step 3. Then click on “404”.
        driver.findElement(By.linkText("404")).click();
        //Step 4. Verify that following message is displayed:"This page returned a 404 status code"
        WebElement msg = driver.findElement(By.xpath("//*[contains(text(),'404 status code')]"));
        Assert.assertTrue(msg.isDisplayed(), "Verify that following message is displayed:This page returned a 404 status code");

    }

    @Test
    public void test12() throws InterruptedException {
        //Step 1. Go to "https://practice-cybertekschool.herokuapp.com"
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. And click on “Status Codes”.
        driver.findElement(By.linkText("Status Codes")).click();
        //Step 3. Then click on “500”.
        driver.findElement(By.linkText("500")).click();
        //Step 4. Verify that following message is displayed:"This page returned a 500 status code"
        WebElement msg = driver.findElement(By.xpath("//*[contains(text(),'500 status code')]"));
        Assert.assertTrue(msg.isDisplayed(), "Verify that following message is displayed:This page returned a 500 status code");

    }
}