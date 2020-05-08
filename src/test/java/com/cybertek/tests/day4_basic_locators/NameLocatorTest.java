package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocatorTest {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        driver.manage().window().maximize();
        Faker faker=new Faker();
        String FullName= faker.name().fullName();
        String EmailAdress=faker.internet().emailAddress();

        WebElement fullNameInputBox=driver.findElement(By.name("full_name"));
        fullNameInputBox.sendKeys(FullName);

        //direct click or write email*****************************
        driver.findElement(By.name("email")).sendKeys(EmailAdress);
        driver.findElement(By.name("wooden_spoon")).click();//sign up click directly

        String expectedMessage="Thank you for signing up. Click the button below to return to the home page.";
        String actualMessage=driver.findElement(By.name("signup_message")).getText();

        if(actualMessage.equals(expectedMessage)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }

        driver.quit();


    }
}
