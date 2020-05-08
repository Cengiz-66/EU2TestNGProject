package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class calisma4 {
    public static void main(String[] args) {

            Faker faker=new Faker();
            String emailAddress = faker.internet().emailAddress();
            String pass = faker.idNumber().valid();
            WebDriver driver= WebDriverFactory.getDriver("chrome");
            driver.get("https://www.facebook.com");
            WebElement emailInputBox = driver.findElement(By.name("email"));
            emailInputBox.sendKeys(emailAddress);

            emailInputBox = driver.findElement(By.name("pass"));
            emailInputBox.sendKeys(pass);

            emailInputBox=driver.findElement(By.id("u_0_b"));
            emailInputBox.click();

            driver.quit();

    }
}
