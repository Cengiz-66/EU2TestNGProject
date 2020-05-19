package com.cybertek.tests.day16_pom;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    LoginPage loginPage=new LoginPage();
    String url=ConfigurationReader.get("url");
    @Test
    public void wrongPasswordTest() {

        loginPage.usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
        loginPage.passwordInput.sendKeys("wrongPassword",Keys.ENTER);
        //loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),url);

    }

    @Test
    public void wrongUsernameTest() {

        loginPage.usernameInput.sendKeys("wrongUsername");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        loginPage.loginBtn.click();

        Assert.assertEquals(driver.getCurrentUrl(),url);

    }
}
