package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class AttributeTest {

    @Test
    public void test1() {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButton=driver.findElement(By.id("blue"));
        //get the value of type attribute
        System.out.println(radioButton.getAttribute("type"));
        //get the value of name attribute
        System.out.println(radioButton.getAttribute("name"));
        //get the value of checked since it is checked the value of checked attribute is selected or not
        System.out.println(radioButton.getAttribute("checked"));
        
        System.out.println(radioButton.getAttribute("outerHTML"));

        driver.quit();
    }
}
