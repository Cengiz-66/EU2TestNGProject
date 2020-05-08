package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class CalismaMultipleWindows {
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
    public void switchWindowsTest() {
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("First title "+driver.getTitle());
        //we will switch to new window
        Set<String> windowHandles = driver.getWindowHandles();
        //loop for each window
        for (String handle : windowHandles) {
            //one by one change it
            driver.switchTo().window(handle);
            //whenever your title equals to your expected window title
            if(driver.getTitle().equals("New Window")) {
                //stop the loop
                break;
            }
        }

        System.out.println("Last title "+driver.getTitle());

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();
        System.out.println("First title "+driver.getTitle());

        Set<String> windowHandles = driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if(driver.getTitle().equals("New Window")) {
                break;
            }
        }

        System.out.println("LAst title "+driver.getTitle());
    }
}
