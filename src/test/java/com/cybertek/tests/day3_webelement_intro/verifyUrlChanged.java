package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyUrlChanged {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        /*Verify URL changed
            1. open browser
            2.go to http://practice.cybertekschool.com/forgot_password Links to an external site.
            3.enter any email
            4. click on Retrieve password
            5.verify that url changed to http://practice.cybertekschool.com/email_sent
         */
        //Find a fake e mail
        Faker faker=new Faker();
        String emailAddress = faker.internet().emailAddress();

        driver.get("http://practice.cybertekschool.com/forgot_password");
        String expectedUrl = "http://practice.cybertekschool.com/email_sent";

        //enter any email***********
        WebElement emailInputBox=driver.findElement(By.name("email"));
        //sendkeys==send keyboard action to the webelement
        emailInputBox.sendKeys(emailAddress);
        Thread.sleep(3000);

        //click the retrieve button
        WebElement findRetrieveButton=driver.findElement(By.id("form_submit"));
        findRetrieveButton.click();
        String actualUrl = driver.getCurrentUrl();

        if(actualUrl.equals(expectedUrl)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.quit();

    }
}
