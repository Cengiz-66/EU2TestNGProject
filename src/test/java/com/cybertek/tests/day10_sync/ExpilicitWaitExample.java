package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExpilicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void closeSetUp() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void Test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        //click start button
        driver.findElement(By.tagName("button")).click();

        //locate username inputbox
        WebElement usernameInputbox=driver.findElement(By.id("username"));

        //wait until the element visible****clickable***intractable
        //How to wait explicitly?
        //create explicit wait object
        WebDriverWait wait=new WebDriverWait(driver,10);

        //calling until method from wait object
        wait.until(ExpectedConditions.visibilityOf(usernameInputbox));
        usernameInputbox.sendKeys("mikesmith");

    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        driver.findElement(By.xpath("//button[@onclick=\"swapInput()\"]")).click();

        WebElement inputBox = driver.findElement(By.cssSelector("[type=\"text\"]"));

        //wait until input box is clickable******
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));
        inputBox.sendKeys("hello");

    }
}