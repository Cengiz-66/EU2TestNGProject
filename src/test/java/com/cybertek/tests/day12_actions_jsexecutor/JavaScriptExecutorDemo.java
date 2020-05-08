package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.JavaScript;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorDemo {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        //driver.manage().window().setPosition(new Point(500, 0));
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,20);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(4_000);
        driver.quit();
    }

    @Test
    public void clickWithJS () {

        driver.get("http://practice.cybertekschool.com/");

        WebElement dropdownLink=driver.findElement(By.linkText("Dropdown"));
        //clicking with JavascriptExecutor
        //create js executor object
        JavascriptExecutor jse=(JavascriptExecutor) driver;
        //use executeScript
        jse.executeScript("arguments[0].click();",dropdownLink);
    }

    @Test
    public void type(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        WebElement inputbox = driver.findElement(By.cssSelector("#input-example>input"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        String str = "Hello disable input";
        jse.executeScript("arguments[0].setAttribute('value', '" + str +"')",inputbox);

    }

    @Test
    public void scrollDownandUp() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0, 100);");

        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            jse.executeScript("window.scrollBy(0, -250);");

        }
    }

    @Test
    public void test() {
        driver.get("http://practice.cybertekschool.com/");
        WebElement dropdownLink=driver.findElement(By.linkText("Dropdown"));
        JavaScript.clickWithJSE(driver,dropdownLink);
    }

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        WebElement inputbox = driver.findElement(By.cssSelector("#input-example>input"));
        String str="Hello World!";
        JavaScript.typeWithJSE(driver,inputbox,str);

    }
}
