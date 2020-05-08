package com.cybertek.tests.homework.homework1;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase6 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void TestCase6() throws InterruptedException {
       // Step 1. Go to "https://www.tempmailaddress.com/"
        driver.get("https://www.tempmailaddress.com/");
        //Step 2. Copy and save email as a string.
        String email=driver.findElement(By.cssSelector("span#email[class=\"animace\"]")).getText();
        System.out.println("email = " + email);
        Thread.sleep(2000);
        //   Step 3. Then go to “https://practice-cybertekschool.herokuapp.com”
        driver.get("https://practice-cybertekschool.herokuapp.com/");
       //  Step 4. And click on “Sign Up For Mailing List".
       driver.findElement(By.linkText("Sign Up For Mailing List")).click();
       //  Step 5. Enter any valid name.
        Faker faker=new Faker();
        String fullName=faker.name().fullName();
        driver.findElement(By.cssSelector("[name=\"full_name\"]")).sendKeys(fullName);
        Thread.sleep(1000);
        // Step 6. Enter email from the Step 2.
        driver.findElement(By.cssSelector("[name=\"email\"]")).sendKeys(email);
        Thread.sleep(1000);
       // Step 7. Click Sign Up
        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
        //Step 8. Verify that following message is displayed:“Thank you for signing up. Click the button below to
       // return to the home page.”
        Thread.sleep(4000);
        WebElement signUpMsg = driver.findElement(By.cssSelector("[name=\"signup_message\"]"));
        Assert.assertTrue(signUpMsg.isDisplayed(),"Verify that sign up message is displayed");
        //Step 9. Navigate back to the “https://www.tempmailaddress.com/”
        driver.get("https://www.tempmailaddress.com/");
       // Step 10. Verify that you’ve received an email from “do-not-reply@practice.cybertekschool.com”
        String actualReplyMsg = driver.findElement(By.xpath("//*[@*=\"from\"]")).getText();
        System.out.println("actualReplyMsg =" + actualReplyMsg);
        String expectedReplyMsg=" do-not-reply@practice.cybertekschool.com";
        Assert.assertTrue(actualReplyMsg.equals(expectedReplyMsg),"Verify that you’ve received an email from :do-not-reply@practice.cybertekschool.com");
        //Step 11. Click on that email to open it.
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@*=\"from\"]")).click();
        //Step 12. Verify that email is from: “do-notreply@practice.cybertekschool.com”
        String actualadress = driver.findElement(By.id("odesilatel")).getText();
        String expectedadress="do-not-reply@practice.cybertekschool.com";
        Assert.assertTrue(actualadress.equals(expectedadress),"Verify that email is from: do-notreply@practice.cybertekschool.com");
        //  Step 13. Verify that subject is: “Thanks for subscribing to practice.cybertekschool.com!”
        String actualsubjectMsg = driver.findElement(By.id("predmet")).getText();
        System.out.println("actualsubjectMsg = " + actualsubjectMsg);
        String expectedsubjectMsg="Thanks for subscribing to practice.cybertekschool.com!";
        Assert.assertTrue(actualsubjectMsg.equals(expectedsubjectMsg),"Verify that subject is: Thanks for subscribing to practice.cybertekschool.com!");
    }

}
