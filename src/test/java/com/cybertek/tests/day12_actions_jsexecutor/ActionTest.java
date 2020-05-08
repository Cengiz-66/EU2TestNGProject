package com.cybertek.tests.day12_actions_jsexecutor;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionTest {

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
         Thread.sleep(2_000);
         driver.quit();
    }

    @Test
    public void hovers() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img1=driver.findElement(By.tagName("img"));
        //Actions class that contains all the user interactions
        //how to create actions object/pasing driver as a constructor
        Actions actions=new Actions(driver);
        //moveToElement(img1)-> hover the element
        //perform() perform the action complete the actions
        actions.moveToElement(img1).perform();

        WebElement link=driver.findElement(By.linkText("View profile"));
        wait.until(ExpectedConditions.visibilityOf(link));
        Assert.assertTrue(link.isDisplayed(),"verify View profile displayed");

    }

    @Test
    public void DragAndDrop() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.cssSelector("[title=\"Accept Cookies\"]")))).click();
        Actions actions=new Actions(driver);
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));
        Thread.sleep(2_000);
        actions.dragAndDrop(source,target).perform();

    }

    @Test
    public void DragAndDropChaining() throws InterruptedException {

        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.cssSelector("[title=\"Accept Cookies\"]")))).click();
        wait.until(ExpectedConditions.invisibilityOf( driver.findElement(By.cssSelector("[title=\"Accept Cookies\"]"))));

        Actions actions=new Actions(driver);
        WebElement source=driver.findElement(By.id("draggable"));
        WebElement target=driver.findElement(By.id("droptarget"));

        //drag and drop without dragAndDrop() methods
        //if you are chaining actions we add perform()
        actions.moveToElement(source).clickAndHold().moveToElement(target).pause(2000).release().perform();

    }

    @Test
    public void homework() throws InterruptedException {
        /**
         * hover over each image in the website
         * verify each name:user text is displayed
         */

        driver.get("http://practice.cybertekschool.com/hovers");
        Actions actions=new Actions(driver);
        List<WebElement> imageLocators = driver.findElements(By.xpath("//img"));
        List<WebElement> names = driver.findElements(By.xpath("//h5"));

        for (int i=0;i<imageLocators.size();i++) {
            actions.moveToElement(imageLocators.get(i)).perform();
            String[] nameSplit = names.get(i).getText().split(":");
            Assert.assertTrue(names.get(i).isDisplayed(),"verify each name:user text is displayed");
            Assert.assertTrue(names.get(i).getText().contains(nameSplit[1]),"verify each name contains user and number");
            Thread.sleep(1000);
        }
    }

}
