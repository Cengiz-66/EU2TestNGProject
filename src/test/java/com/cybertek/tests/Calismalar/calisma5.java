package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class calisma5 {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://www.amazon.com");

        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("cover secreen");
        Thread.sleep(1000);

        searchBox=driver.findElement(By.className("nav-input"));
        searchBox.click();

        searchBox=driver.findElement(By.id("a-autoid-0-announce"));
        searchBox.click();

        searchBox=driver.findElement(By.id("s-result-sort-select_1"));
        searchBox.click();

       driver.quit();
    }
}
