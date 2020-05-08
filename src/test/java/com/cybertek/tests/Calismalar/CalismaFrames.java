package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalismaFrames {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");

    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        //how to switch frames
        //1.Switch USING BY NAME OR ID attribute of iframe

        driver.switchTo().frame("mce_0_ifr");
        //clear before sendkeys
        Thread.sleep(2000);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mahmut Tuncer1");
        //goes back to first frame(main html)
        //goes back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();
        Thread.sleep(2000);

        //2.USING INDEX
        driver.switchTo().frame(0);
        Thread.sleep(2000);
        //clear before sendkeys
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mahmut Tuncer2");
        Thread.sleep(2000);
        //second way to switch parent
        driver.switchTo().parentFrame();
        //3.USING WEBELEMENT
        //locating iframe with any valid locator
        WebElement element=driver.findElement(By.tagName("iframe"));
        driver.switchTo().frame(element);
        Thread.sleep(2000);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Mahmut Tuncer3");
    }

    @Test
    public void test2() {
        driver.get("http://practice.cybertekschool.com/nested_frames");

        driver.switchTo().frame(0);
        //top has 3 children left middle right
        driver.switchTo().frame("frame-middle");
        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        driver.switchTo().parentFrame();
        WebElement element=driver.findElement(By.xpath("//frame[@src='/frame_right']"));
        driver.switchTo().frame(element);




    }
}
