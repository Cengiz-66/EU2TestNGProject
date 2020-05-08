package com.cybertek.tests.day8_types_of_elements2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class CheckBoxDemo {
    WebDriver driver;
    @Test
    public void Test1() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement checkbox1=driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2=driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[2]"));

        //how to verify checkbox is selected or not?

        System.out.println("checkbox1.isSelected() = " + checkbox1.isSelected());
        System.out.println("checkbox2.isSelected() = " + checkbox2.isSelected());

        //verify checkbox1 is not selected and checkbox2 is selected
        Assert.assertFalse(checkbox1.isSelected(),"verify that cbox1 is NOT selected");
        Assert.assertTrue(checkbox2.isSelected(),"verify that cbx2 is selected");
        //how to click checkbox1
        checkbox1.click();

        Assert.assertTrue(checkbox1.isSelected(),"verify that checkbox1 is selected");
        Assert.assertTrue(checkbox2.isSelected(),"verify that cbx2 is selected");


        driver.quit();

    }


}
