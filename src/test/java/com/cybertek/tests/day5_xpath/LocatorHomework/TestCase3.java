package com.cybertek.tests.day5_xpath.LocatorHomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase3 {

    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.wikipedia.org");

        Select dropdown=new Select(driver.findElement(By.id("searchLanguage")));
        dropdown.selectByValue("en");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        driver.findElement(By.xpath("//i[@class=\"sprite svg-search-icon\"]")).click();
        driver.findElement(By.linkText("Selenium (software)")).click();

        if(driver.getCurrentUrl().endsWith("Selenium_(software)")) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }

        driver.quit();

    }
}
