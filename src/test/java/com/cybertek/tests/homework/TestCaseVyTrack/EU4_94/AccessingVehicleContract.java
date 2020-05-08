package com.cybertek.tests.homework.TestCaseVyTrack.EU4_94;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AccessingVehicleContract {

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
    public void EU4_166_AuthorizedUser() throws InterruptedException {

        Actions actions=new Actions(driver);
        driver.get("http://qa1.vytrack.com/user/login");
        //enter email address
        WebElement emailInputBox = driver.findElement(By.cssSelector("#prependedInput"));
        emailInputBox.sendKeys("storemanager57");
        wait.until(ExpectedConditions.visibilityOf(emailInputBox));
        //enter password
        WebElement passwordInputBox = driver.findElement(By.cssSelector("#prependedInput2"));
        passwordInputBox.sendKeys("UserUser123");
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        //click login button
        driver.findElement(By.cssSelector("#_submit")).click();
        //wait until loading frame invisible
        WebElement loadingFrame=driver.findElement(By.cssSelector("div [class=\"loader-mask\"]>div"));
        wait.until(ExpectedConditions.invisibilityOf(loadingFrame));
        //move to fleet
        WebElement fleet=driver.findElement(By.cssSelector(".dropdown.dropdown-level-1:nth-of-type(2)"));
        wait.until(ExpectedConditions.visibilityOf(fleet));
        actions.moveToElement(fleet).perform();
        //click Vehicle Contracts
        WebElement contracts=driver.findElement(By.xpath("//span[.='Vehicle Contracts']"));
        wait.until(ExpectedConditions.visibilityOf(contracts));
        actions.moveToElement(contracts).click().perform();
        //wait title
        wait.until(ExpectedConditions.invisibilityOf(loadingFrame));
        String title="All - Vehicle Contract - Entities - System - Car - Entities - System";
        wait.until(ExpectedConditions.titleIs(title));
        //subtitle check
        WebElement subTitle = driver.findElement(By.cssSelector("[class=\"oro-subtitle\"]"));
        Assert.assertTrue(subTitle.isDisplayed(),"Verify that page subtitle is uploaded and accessed the all contracts");
        //click user menu
        WebElement userMenu = driver.findElement(By.cssSelector("[id=\"user-menu\"]"));
        actions.click(userMenu).perform();
        //click logout button
         WebElement logout = driver.findElement(By.linkText("Logout"));
         wait.until(ExpectedConditions.visibilityOf(logout));
         actions.moveToElement(logout).click().perform();
         String expectedLoginTitle="Login";
         wait.until(ExpectedConditions.titleIs(expectedLoginTitle));
         String actualLoginTitle=driver.getTitle();
         Assert.assertTrue(actualLoginTitle.equals(expectedLoginTitle),"Verify that go back to login page");
    }

    @Test
    public void EU4_167_NonAuthorizedUser() throws InterruptedException {

        Actions actions=new Actions(driver);
        driver.get("http://qa1.vytrack.com/user/login");
        //enter email address
        WebElement emailInputBox = driver.findElement(By.cssSelector("#prependedInput"));
        emailInputBox.sendKeys("user11");
        wait.until(ExpectedConditions.visibilityOf(emailInputBox));
        //enter password
        WebElement passwordInputBox = driver.findElement(By.cssSelector("#prependedInput2"));
        passwordInputBox.sendKeys("UserUser123");
        wait.until(ExpectedConditions.visibilityOf(passwordInputBox));
        //click login button
        driver.findElement(By.cssSelector("#_submit")).click();

        //move to fleet
        WebElement fleet=driver.findElement(By.cssSelector(".dropdown.dropdown-level-1:nth-of-type(1)"));
        wait.until(ExpectedConditions.visibilityOf(fleet));
        actions.moveToElement(fleet).perform();
        //click Vehicle Contracts
        WebElement contracts=driver.findElement(By.xpath("//span[.='Vehicle Contracts']"));
        wait.until(ExpectedConditions.visibilityOf(contracts));
        actions.moveToElement(contracts).click().perform();
        if(driver.getTitle().equals("403 - Forbidden")) {
            WebElement button = driver.findElement(By.xpath("//button"));
            WebElement alertMessage = driver.findElement(By.cssSelector("[class=\"error-page-description\"]"));
            System.out.println("alertMessage403 = " + alertMessage.getText());
            Assert.assertTrue(alertMessage.isDisplayed(),"verify that alert message is displayed");
            wait.until(ExpectedConditions.elementToBeClickable(button)).click();
        } else {
            //verify that alert message is displayed
            WebElement alertMessage = driver.findElement(By.xpath("//*[contains(text(),'permission to perform')]"));
            wait.until(ExpectedConditions.visibilityOf(alertMessage));
            System.out.println("alertMessage = " + alertMessage.getText());
            Assert.assertTrue(alertMessage.isDisplayed(),"verify that permission message is displayed");
        }
        //move to fleet
         fleet=driver.findElement(By.cssSelector(".dropdown.dropdown-level-1:nth-of-type(1)"));
        wait.until(ExpectedConditions.visibilityOf(fleet));
        actions.moveToElement(fleet).perform();
        //click Vehicle Contracts
        contracts=driver.findElement(By.xpath("//span[.='Vehicle Contracts']"));
        wait.until(ExpectedConditions.visibilityOf(contracts));
        actions.moveToElement(contracts).click().perform();
        //verify that alert message is displayed
        WebElement alertMessage = driver.findElement(By.xpath("//*[contains(text(),'permission to perform')]"));
        wait.until(ExpectedConditions.visibilityOf(alertMessage));
        System.out.println("alertMessage = " + alertMessage.getText());
        Assert.assertTrue(alertMessage.isDisplayed(),"verify that permission message is displayed");
        Thread.sleep(2000);
        //click user menu
        WebElement userMenu = driver.findElement(By.cssSelector("[id=\"user-menu\"]"));
        actions.click(userMenu).perform();
        //click logout button
        WebElement logout = driver.findElement(By.linkText("Logout"));
        wait.until(ExpectedConditions.visibilityOf(logout));
        actions.moveToElement(logout).click().perform();
        String expectedLoginTitle="Login";
        wait.until(ExpectedConditions.titleIs(expectedLoginTitle));
        String actualLoginTitle=driver.getTitle();
        Assert.assertTrue(actualLoginTitle.equals(expectedLoginTitle),"Verify that go back to login page");

    }

}
