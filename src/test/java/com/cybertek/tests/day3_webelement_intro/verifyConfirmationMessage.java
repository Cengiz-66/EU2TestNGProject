package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyConfirmationMessage {
    public static void main(String[] args) {

        /**
         * Verify confirmation message
         * open browser
         * go to http://practice.cybertekschool.com/forgot_password Links to an external site.
         * enter any email
         * verify that email is displayed in the input box
         * click on Retrieve password
         * verify that confirmation message says 'Your e-mail's been sent!'
         */

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement inputBox=driver.findElement(By.name("email"));
        Faker faker=new Faker();
        String expectedemail=faker.internet().emailAddress();
        inputBox.sendKeys(expectedemail);

        //somehow we should get text from webelements
        //1.getText() method but it is not working input boxes***************
        //2.getAttribute("value") getting text especially inputboxes

        String actualemail=inputBox.getAttribute("value");

        //verify email is displayed
        if(actualemail.equals(expectedemail)) {
            System.out.println("TEST1 PASS");
        } else {
            System.out.println("TEST2 FAIL");
            System.out.println("actualemail = " + actualemail);
            System.out.println("expectedemail = " + expectedemail);
        }

        //click on Retrieve password
        WebElement retrieveButtonFind=driver.findElement(By.id("form_submit"));
        retrieveButtonFind.click();

        //verify that confirmation message says 'Your e-mail's been sent!'
        WebElement actualMessage=driver.findElement(By.name("confirmation_message"));
        String expectedMessage="Your e-mail's been sent!";

        if(actualMessage.getText().equals(expectedMessage)) {
            System.out.println("PASS2");
        } else {
            System.out.println("expectedMessage = " + expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        driver.quit();

    }
}
