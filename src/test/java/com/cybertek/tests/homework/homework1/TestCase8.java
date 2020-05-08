package com.cybertek.tests.homework.homework1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase8 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        //Step 1. Go to "https://practice-practicecybertekschool.herokuapp.com"
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        //Step 2. And click on “Autocomplete”.
        driver.findElement(By.linkText("Autocomplete")).click();
        //Step 3. Enter “United States of America” into country input box.
       driver.findElement(By.cssSelector("[name=\"myCountry\"]")).sendKeys("u");
        List<WebElement> countries = driver.findElements(By.cssSelector("div.autocomplete-items>div"));
        for (WebElement country : countries) {
            if(country.getText().contains("America")) {
                country.click();
                break;
            }
        }
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[value=\"Submit\"]")).click();
        Thread.sleep(1000);
        //Step 4. Verify that following message is displayed:“You selected: United States of America”
        WebElement resultMsg = driver.findElement(By.cssSelector("[id=\"result\"]"));
        Assert.assertTrue(resultMsg.isDisplayed(),"Verify that following message is displayed: You selected: United States of America");

    }
}

