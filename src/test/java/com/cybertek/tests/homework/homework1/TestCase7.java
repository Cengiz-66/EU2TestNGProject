package com.cybertek.tests.homework.homework1;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase7 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");

        //Step 2. And click on “File Upload".
        driver.findElement(By.linkText("File Upload")).click();
        //Step 3. Upload any file with .txt extension from your computer.
       // driver.findElement(By.cssSelector("#file-upload")).click();
        driver.findElement(By.cssSelector("#file-upload")).sendKeys("C:\\Users\\cenki\\Desktop\\cybertek weekly lesson\\a.txt");
        //Step 4. Click “Upload” button.
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        //Step 5. Verify that subject is: “File Uploaded!”
        WebElement uploadMsg = driver.findElement(By.xpath("//*[@id=\"content\"]//h3"));
        System.out.println("uploadMsg = " + uploadMsg.getText());
        Assert.assertTrue(uploadMsg.isDisplayed(),"Verify that subject is: File Uploaded!");
        //Step 6. Verify that uploaded file name is displayed.
        WebElement fileMsg = driver.findElement(By.id("uploaded-files"));
        System.out.println("fileMsg = " + fileMsg.getText());
        Assert.assertTrue(fileMsg.isDisplayed(),"Verify that uploaded file name is displayed.");
        Thread.sleep(2000);
    }
}
