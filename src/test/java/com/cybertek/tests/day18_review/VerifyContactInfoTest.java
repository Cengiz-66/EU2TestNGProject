package com.cybertek.tests.day18_review;

import com.cybertek.pages.ContactInfoPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class VerifyContactInfoTest extends TestBase {

    LoginPage loginPage=new LoginPage();

    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */

    @Test
    public void contactDetailTest() {
        extentLogger=report.createTest("Contact info verification");
        loginPage.loginAsSalesManager();
        extentLogger.info("username:"+ ConfigurationReader.get("salesmanager_username"));
        extentLogger.info("password:"+ConfigurationReader.get("salesmanager_password"));
        extentLogger.info("Login as a sales manager");
        ContactsPage contactsPage=new ContactsPage();
        contactsPage.navigateToModule("Customers","Contacts");
        extentLogger.info("navigate to customers to contacts");
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
        extentLogger.info("Click the mbrackstone9@example.com adress");

        ContactInfoPage contactInfoPage=new ContactInfoPage();

        List<String> expected= Arrays.asList("Mariam Brackstone","mbrackstone9@example.com","+18982323434");
        List<WebElement> actualElement = Arrays.asList(contactInfoPage.fullname, contactInfoPage.email, contactInfoPage.phone);
        List<String> actual = BrowserUtils.getElementsText(actualElement);
        extentLogger.info("Get the actual name, email and phone");

        Assert.assertEquals(actual,expected,"Verify the name phone and email");
        extentLogger.pass("Passed");


    }
}
