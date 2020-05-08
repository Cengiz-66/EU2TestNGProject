package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;

public class calisma6 {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("http://www.google.com");
        WebElement searchBox=driver.findElement(By.name("q"));
        searchBox.sendKeys("cybertek");

        searchBox=driver.findElement(By.name("btnK"));
        searchBox.click();

        searchBox=driver.findElement(By.id("result-stats"));
        String searchResult=searchBox.getText();
        driver.quit();

    }
}
