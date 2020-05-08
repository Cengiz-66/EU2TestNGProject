package com.cybertek.tests.day5_xpath.LocatorHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase1 {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.ebay.com/");
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@type=\"text\"][@name=\"_nkw\"]")).sendKeys("watch");
        driver.findElement(By.id("gh-btn")).click();
        System.out.println(driver.findElement(By.xpath("//h1[@class=\"srp-controls__count-heading\"]")).getText());

        driver.quit();
    }
}
