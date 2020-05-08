package com.cybertek.tests.day5_xpath.LocatorHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCase2 {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        String searchTerm="watch";
        driver.navigate().to("https://www.ebay.com");
        driver.findElement(By.xpath("//input[@type=\"text\"][@name=\"_nkw\"]")).sendKeys(searchTerm);
        driver.findElement(By.id("gh-btn")).click();

        if(driver.getTitle().contains(searchTerm)) {
            System.out.println("PASS: "+searchTerm+" is in the title.");
        } else {
            System.out.println("FAIL: "+searchTerm+" is in the title.");
        }

        driver.quit();

    }
}
