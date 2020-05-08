package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("java");

        WebElement searchClick=driver.findElement(By.xpath("//input[@type=\"submit\"]"));
        searchClick.click();

        System.out.println(driver.findElement(By.xpath("//span[@dir=\"auto\"][contains(text(),'results for')]")).getText()+
                driver.findElement(By.xpath("//span[@class=\"a-color-state a-text-bold\"][@dir=\"auto\"]")).getText());

        driver.quit();

    }
}
