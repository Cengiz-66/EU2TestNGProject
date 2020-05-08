package com.cybertek.tests.day7_types_Of_Elements;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisabledElements {
    @Test
    public void test1(){

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement greenRadioButton=driver.findElement(By.id("green"));

        //how to check if element enabled?
        System.out.println("Is element enabled: "+greenRadioButton.isEnabled());

        Assert.assertFalse(greenRadioButton.isEnabled(),"verify green button is not enabled");

    }

    @Test
    public void test2(){

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputbox = driver.findElement(By.cssSelector("#input-example>input"));

        System.out.println("Is input box enable: "+inputbox.isEnabled());
        Assert.assertFalse(inputbox.isEnabled(),"verify that inputbox is enable ");

    }


}
