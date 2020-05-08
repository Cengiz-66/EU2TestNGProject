package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class calisma1 {
    public static void main(String[] args) {
        /**
         * open chrome browser
         * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         * click on Retrieve password
         * verify that url did not change
         */
        /*Verify URL changed
            1. open browser
            2.go to http://practice.cybertekschool.com/forgot_password Links to an external site.
            3.enter any email
            4. click on Retrieve password
            5.verify that url changed to http://practice.cybertekschool.com/email_sent
         */

        Faker faker=new Faker();
        String fakeEmail=faker.internet().emailAddress();

        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");

        WebElement findEmail=driver.findElement(By.name("email"));
        findEmail.sendKeys(fakeEmail);


        WebElement retrieveButton=driver.findElement(By.id("form_submit"));
        retrieveButton.click();
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl="http://practice.cybertekschool.com/email_sent";

        if(actualUrl.equals(expectedUrl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.quit();


    }
}
