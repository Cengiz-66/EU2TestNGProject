package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class XpathCalisma {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        Faker faker=new Faker();

        driver.get("https://cybertekschool.com/");
        driver.findElement(By.xpath("//input[@type=\"text\"][@name=\"SingleLine\"]")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@type=\"text\"][@name=\"SingleLine1\"]")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@type=\"email\"][@name=\"Email\"]")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.xpath("//input[@type=\"tel\"][@name=\"PhoneNumber_countrycode\"]")).sendKeys(faker.phoneNumber().cellPhone());

        //select an option
        Select dropDown=new Select(driver.findElement(By.xpath("//select[@name=\"Program\"]")));
        dropDown.selectByValue("Java SDET Online");
        Select countryDropDown=new Select(driver.findElement(By.xpath("//select[@onchange=\"yesnoCheck(this);\"]")));
        countryDropDown.selectByValue("Turkey");
        driver.findElement(By.xpath("//input[@type=\"text\"][@name=\"SingleLine2\"]")).sendKeys("New Kurs beginnig time!");
        driver.findElement(By.xpath("//textarea[@name=\"MultiLine\"]")).sendKeys("Bu akşam ölürüm beni kimse tutamaz. Sen beni tutamazsın yıldızlar tutamaz.");
        Thread.sleep(2000);

        driver.quit();


    }
}
