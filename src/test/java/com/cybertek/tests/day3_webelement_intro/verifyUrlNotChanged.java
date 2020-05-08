package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlNotChanged {
    public static void main(String[] args) throws InterruptedException {
        /**
         * open chrome browser
         * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         * click on Retrieve password
         * verify that url did not change
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save url before we click retrieve password button******
        String expectedurl = driver.getCurrentUrl();

        //click on Retrieve password*******************
        WebElement retrievePasswordButton=driver.findElement(By.id("form_submit"));
        retrievePasswordButton.click();
        String actualurl = driver.getCurrentUrl();

        //verify that url did not change****************
        if(actualurl.equals(expectedurl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        //close browser after it's run
       // driver.quit();

    }
}
