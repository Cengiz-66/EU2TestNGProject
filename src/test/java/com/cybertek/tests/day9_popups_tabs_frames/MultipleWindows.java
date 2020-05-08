package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class MultipleWindows {

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

      //get tittle
        String title1=driver.getTitle();
        System.out.println("title1 = " + title1);
        //click click here button
        driver.findElement(By.xpath("//*[.='Click Here']")).click();
        //get title again
        String title2=driver.getTitle();
        System.out.println("title2 = " + title2);

        String currentWindowHandle = driver.getWindowHandle();
        System.out.println(currentWindowHandle);

        //we will switch to new window
        Set<String> windowHandles =  driver.getWindowHandles();

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }

        System.out.println("After switching "+driver.getTitle());
    }

    @Test
    public void morethan2WindowsTest() {//*********************************************
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        System.out.println("Title Before switching "+driver.getTitle());

        //we will switch to new window
        Set<String> windowHandles =  driver.getWindowHandles();
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
        System.out.println("Title After switching "+driver.getTitle());
        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}
