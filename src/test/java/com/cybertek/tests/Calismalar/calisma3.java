package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class calisma3 {
    public static void main(String[] args) {
        //go to cybertekschool.com and fill the blanks

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://cybertekschool.com/#");

        //fake data comes from java faker
        Faker faker=new Faker();
        String expectedName=faker.name().firstName();
        String expectedLastName=faker.name().lastName();
        String expectedEmail=faker.internet().emailAddress();
        String expectedNumber=faker.phoneNumber().phoneNumber();
        String expectedText1="Yussuf yussuf deyi aglayacaksın!";

        //find element side
        WebElement enterUserName=driver.findElement(By.name("SingleLine"));
        enterUserName.sendKeys(expectedName);
        enterUserName=driver.findElement(By.name("SingleLine1"));
        enterUserName.sendKeys(expectedLastName);
        enterUserName=driver.findElement(By.name("Email"));
        enterUserName.sendKeys(expectedEmail);
        enterUserName=driver.findElement(By.name("PhoneNumber_countrycode"));
        enterUserName.sendKeys(expectedNumber);

        //select a selection from dropdown
        enterUserName=driver.findElement(By.name("Program"));
        Select dropdown = new Select(enterUserName);
        dropdown.selectByValue("Java SDET On-Campus Virginia");

        enterUserName=driver.findElement(By.name("SingleLine2"));
        enterUserName.sendKeys(expectedText1);

    }
}
