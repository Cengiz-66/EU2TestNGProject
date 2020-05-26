package com.cybertek.tests.day17_extent_reports;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){

        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter Username: User1");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter Password: somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("click login button");

        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        //we put after assertion so if the assertion fails, it will not send pass to report
        extentLogger.pass("Wrong Passord Test is passed");
    }

    @Test
    public void wrongUsernameTest(){
        //name of the test for report
        extentLogger = report.createTest("Wrong Username Test");
        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("someusername");
        extentLogger.info("Enter username: someusername");

        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Enter password: UserUser123");

        loginPage.loginBtn.click();
        extentLogger.info("Click login button");

        extentLogger.info("verify page url");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com");

        extentLogger.pass("PASS: Wrong password Test");
    }
}