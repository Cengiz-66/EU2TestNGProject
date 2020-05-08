package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class calisma2 {
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

        Faker faker=new Faker();
        String fakeEmail=faker.internet().emailAddress();

        WebElement inputBox=driver.findElement(By.name("email"));
        inputBox.sendKeys(fakeEmail);

        String actualEmail = inputBox.getAttribute("value");

        if(actualEmail.equals(fakeEmail)) {
            System.out.println("PASS1");
        } else {
            System.out.println("FAIL1");
        }

        WebElement retrieveButton=driver.findElement(By.id("form_submit"));
        retrieveButton.click();

        WebElement actualMessage=driver.findElement(By.name("confirmation_message"));
        String actualMessageText = actualMessage.getText();
        String expectedMessageText="Your e-mail's been sent!";

        if(actualMessageText.equals(expectedMessageText)) {
            System.out.println("PASS2");
        } else {
            System.out.println("FAIL2");
        }

        driver.quit();

    }
}
