package com.cybertek.tests.Calismalar;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CalismaNextBase1 {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver= Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait=new WebDriverWait(driver,20);
        actions=new Actions(driver);
    }

    @AfterMethod
    public void tearDown () throws InterruptedException {
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @Test
    public void test() throws InterruptedException {
        //go to nextbasecrm.com
        driver.get(ConfigurationReader.get("nextbase_url"));
        wait.until(ExpectedConditions.titleIs("Authorization"));
        //enter username
        driver.findElement(By.cssSelector("[name=\"USER_LOGIN\"]")).sendKeys(ConfigurationReader.get("nextbase_user"));
        //enter password
        driver.findElement(By.cssSelector("[name=\"USER_PASSWORD\"]")).sendKeys(ConfigurationReader.get("nextbase_password"));
        //click login button
        driver.findElement(By.cssSelector("[type=\"submit\"]")).click();
        wait.until(ExpectedConditions.titleContains("Portal"));
        //click time management button
        WebElement moveTimer = driver.findElement(By.id("timeman-block"));
        actions.moveToElement(moveTimer).click().perform();
        //click continue button
        WebElement continueWorkingDay = driver.findElement(By.xpath("//span[.='Continue working day']"));
        actions.click(continueWorkingDay).perform();
        actions.moveToElement(moveTimer).click().perform();
        //click message button
        driver.findElement(By.id("feed-add-post-form-tab-message")).click();
       //click attachment
        Thread.sleep(2000);
        WebElement attachment = driver.findElement(By.cssSelector("[id=\"bx-b-uploadfile-blogPostForm\"]"));
        attachment.click();
        Thread.sleep(2000);
        //click select document from Bitrix24
        WebElement upload = driver.findElement(By.xpath("(//span[.='Select document from Bitrix24'])[1]"));
        upload.click();
        //click testfile
        WebElement file = driver.findElement(By.cssSelector("[title=\"Name: testfile.txt\"]"));
        wait.until(ExpectedConditions.elementToBeClickable(file)).click();
        //click accept button
        driver.findElement(By.cssSelector("[class=\"popup-window-button popup-window-button-accept\"]")).click();
        wait.until(ExpectedConditions.invisibilityOf(file));
        //click send button
        WebElement sendButton = driver.findElement(By.id("blog-submit-button-save"));
        sendButton.click();
        //click user block
        WebElement userBlock = driver.findElement(By.id("user-block"));
        actions.moveToElement(userBlock).click().perform();
        //click log out
        WebElement logOut = driver.findElement(By.xpath("//span[.='Log out']"));
        wait.until(ExpectedConditions.visibilityOf(logOut));
        actions.moveToElement(logOut).click().perform();

    }
}
