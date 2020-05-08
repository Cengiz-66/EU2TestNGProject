package com.cybertek.tests.day4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class tagNameLocator {

    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullNameInputBox=driver.findElement(By.name("full_name"));
        fullNameInputBox.sendKeys("ahmet mahmut");

        WebElement emailInputbox=driver.findElement(By.name("email"));
        emailInputbox.sendKeys("abc@gmx.com");

        //click the button with the tagName************
        driver.findElement(By.tagName("button")).click();

        System.out.println(driver.findElement(By.tagName("h3")).getText());
    }
}
