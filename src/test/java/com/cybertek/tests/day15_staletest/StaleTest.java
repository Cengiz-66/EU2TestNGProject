package com.cybertek.tests.day15_staletest;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StaleTest extends TestBase {

    @Test
    public void test1() {
        driver.get("https://www.google.com");
        WebElement inputBox=driver.findElement(By.name("q"));
        inputBox.sendKeys("selenium"+ Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.id("result-stats")).isDisplayed());
        //go back
        driver.navigate().back();
        //for stale element error-> we need to find the locator again************
        inputBox=driver.findElement(By.name("q"));
        inputBox.sendKeys("java"+ Keys.ENTER);
        Assert.assertTrue(driver.findElement(By.id("result-stats")).isDisplayed());
    }
}
