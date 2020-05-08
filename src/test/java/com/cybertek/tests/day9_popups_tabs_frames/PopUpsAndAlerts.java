package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpsAndAlerts {

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
    public void test1() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();
        Thread.sleep(2000);
        //click the no button
        driver.findElement(By.xpath("//button[.='No']")).click();

        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();
        Thread.sleep(2000);

        //click the yes button
        driver.findElement(By.xpath("//button[.='Yes']")).click();

    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        //locate click the for JS alert button
        driver.findElement(By.xpath("//button[1]")).click();

        //Alert class coming from selenium class*****
        Alert alert=driver.switchTo().alert();
        Thread.sleep(2000);

        //click OK button on alert
        alert.accept();

        //locate click the for JS confirm button
        driver.findElement(By.xpath("//button[2]")).click();
        Thread.sleep(2000);

        //Click the cancel button
        alert.dismiss();

        Faker faker=new Faker();
        String name=faker.name().fullName();

        //locate click the for JS Prompt button
        driver.findElement(By.xpath("//button[3]")).click();
        Thread.sleep(2000);

        //sendkeys to alert and click OK
        alert.sendKeys(name);
        alert.accept();
        Thread.sleep(5000);
        //get the entered message from the page
        String expected="You entered: "+name;
        String actual=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actual,expected,"verify that entered message is displayed");

    }
}
