package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.JavaScript;
import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CalismaVyTrack {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUP() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void test1_DragDrop() throws InterruptedException {

        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.cssSelector("#prependedInput")).sendKeys("user11");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();
        WebElement loaderFrame = driver.findElement(By.cssSelector("[class=\"loader-frame\"]"));
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));

        //go to fleet and vehicles and click
        WebElement fleet = driver.findElement(By.xpath("(//span[contains(text(),'Fleet')])[1]"));
        actions.moveToElement(fleet).perform();
        WebElement vehicles = driver.findElement(By.xpath("(//span[contains(text(),'Vehicles')])[1]"));
        wait.until(ExpectedConditions.visibilityOf(vehicles));
        actions.moveToElement(vehicles).click().perform();
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));

        //click the second car
        driver.findElement(By.xpath("//tbody/tr[2]/td[1]")).click();
        wait.until(ExpectedConditions.invisibilityOf(loaderFrame));
        Thread.sleep(3000);

        //click add event
        WebElement addEventButton = driver.findElement(By.xpath("//*[.='Add Event']"));
        JavaScript.clickWithJSE(driver,addEventButton);
        Thread.sleep(2000);


        //fill in the name organization email and save fields
        driver.findElement(By.name("oro_calendar_event_form[title]")).sendKeys("event title automated by me");
        WebElement redColor = driver.findElement(By.xpath("(//*[@class=\"color\"])[9]"));
        actions.moveToElement(redColor).click().perform();
        driver.findElement(By.name("oro_calendar_event_form[organizerDisplayName]")).sendKeys("organizer name here");
        driver.findElement(By.name("oro_calendar_event_form[organizerEmail]")).sendKeys("a@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();


    }
}
