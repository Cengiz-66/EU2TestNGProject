package com.cybertek.tests.homework.homework1;

import com.cybertek.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class testCase1_2_3_4_5 {
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
    public void testCase1() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("[name=\"birthday\"]")).sendKeys("wrong_dob");
        WebElement warningMsg = driver.findElement(By.cssSelector("[data-bv-for=\"birthday\"][data-bv-result=\"INVALID\"]"));
        Assert.assertTrue(warningMsg.isDisplayed(), "verify that warning message is displayed");

    }

    @Test
    public void testCase2() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        List<WebElement> languages = driver.findElements(By.cssSelector(".form-check.form-check-inline"));

        for (WebElement language : languages) {
            Assert.assertTrue(language.isDisplayed(), "Verify that following options for programming languages are displayed:" +
                    " c++, java,JavaScript");
        }
    }

    @Test
    public void testCase3() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();

        driver.findElement(By.cssSelector("[name=\"firstname\"]")).sendKeys("a");
        WebElement warnMsg = driver.findElement(By.cssSelector("[data-bv-for=\"firstname\"][data-bv-result=\"INVALID\"]"));
        System.out.println(warnMsg.getText());
        Assert.assertTrue(warnMsg.isDisplayed(), "Verify that warning message is displayed");

    }

    @Test
    public void testCase4() {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        driver.findElement(By.cssSelector("[name=\"lastname\"]")).sendKeys("a");
        WebElement warnMsg = driver.findElement(By.cssSelector("[data-bv-for=\"lastname\"][data-bv-result=\"INVALID\"]"));
        System.out.println(warnMsg.getText());
        Assert.assertTrue(warnMsg.isDisplayed(), "Verify that warning message is displayed");
    }

    @Test
    public void testCase5() throws InterruptedException {
        driver.get("https://practice-cybertekschool.herokuapp.com");
        //Step 2. Click on “Registration Form”
        driver.findElement(By.xpath("//a[.='Registration Form']")).click();
        //fake data from java Faker**
        Faker faker=new Faker();
        String name=faker.name().firstName();
        String lastname=faker.name().lastName();
        String userName=name+"66";
        String email=faker.internet().emailAddress();
        String password="user123456";
        String phoneNumber=faker.phoneNumber().cellPhone();

        //Step 3. Enter any valid first name.
        driver.findElement(By.cssSelector("[name=\"firstname\"]")).sendKeys(name);
        //Step 4. Enter any valid last name.
        driver.findElement(By.cssSelector("[name=\"lastname\"]")).sendKeys(lastname);
        //Step 5. Enter any valid user name.
        driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys(userName);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[name=\"email\"]")).sendKeys(email);
        //Step 6. Enter any valid password.
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(password);
        Thread.sleep(2000);
        //Step 7. Enter any valid phone number.
        driver.findElement(By.cssSelector("[name=\"phone\"]")).sendKeys(phoneNumber);
        Thread.sleep(2000);
        //Step 8. Select gender.
        driver.findElement(By.xpath("//*[@value=\"male\"]")).click();
        //Step 9. Enter any valid date of birth.
        driver.findElement(By.cssSelector("[name=\"birthday\"]")).sendKeys("01/01/1990");
        Thread.sleep(1000);
        //Step 10. Select any department.
        Select departmant=new Select(driver.findElement(By.cssSelector("[name=\"department\"]")));
        departmant.selectByValue("AO");
        Thread.sleep(2000);
        //Step 11. Enter any job title.
        Select jobTitle=new Select(driver.findElement(By.cssSelector("[name=\"job_title\"]")));
        jobTitle.selectByVisibleText("SDET");
        Thread.sleep(1000);
        //Step 12. Select java as a programming language.
        driver.findElement(By.xpath("//label[.='Java']")).click();
        Thread.sleep(1000);
        //Step 13. Click Sign up.
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        /*Step 14. Verify that following success message is displayed: “You've successfully completed
        registration!”*/
        WebElement msg = driver.findElement(By.cssSelector(".alert.alert-success>p"));
        System.out.println(msg.getAttribute("innerHTML"));
        Assert.assertTrue(msg.isDisplayed(),"Verify that success message is displayed");
    }
}