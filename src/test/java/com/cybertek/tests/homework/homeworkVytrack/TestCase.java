package com.cybertek.tests.homework.homeworkVytrack;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestCase extends TestBase {
    LoginPage loginPage = new LoginPage();

    @Test
    public void testCase1() {
        extentLogger=report.createTest("Test case #1");
        loginPage.loginAsStoreManager();

        extentLogger.info("Enter username:"+ ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Enter password:"+ConfigurationReader.get("storemanager_password"));
        extentLogger.info("Click login button");


        new DashboardPage().navigateToModule("Activities", "Calendar Events");
        extentLogger.info("Navigate To Activities --> Calendar Events");

        wait.until(ExpectedConditions.titleIs("All - Calendar Events - Activities"));
        //BrowserUtils.waitFor(4);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        String expected = "Options";
        String actual = calendarEventsPage.optionsSubtitle.getText();

        Assert.assertTrue(actual.contains(expected), "verify that page subtitle 'Options' is displayed ");
        extentLogger.pass("Test case #1 passed");


    }

    @Test
    public void testCase2() {
        extentLogger=report.createTest("Test case #2");
        loginPage.loginAsStoreManager();

        extentLogger.info("Enter username:"+ ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Enter password:"+ConfigurationReader.get("storemanager_password"));
        extentLogger.info("Click login button");


        new DashboardPage().navigateToModule("Activities", "Calendar Events");
        extentLogger.info("Navigate To Activities --> Calendar Events");

        wait.until(ExpectedConditions.titleIs("All - Calendar Events - Activities"));
        //BrowserUtils.waitFor(4);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        String expected = "1";
        String actual = calendarEventsPage.pageNumber.getAttribute("value");

        //System.out.println("actual = " + actual);

        Assert.assertEquals(actual, expected, "Verify that page number is equals to '1'");
        extentLogger.pass("Test case #2 passed");


    }

    @Test
    public void testCase3() {
        extentLogger=report.createTest("Test case #3");
        loginPage.loginAsStoreManager();

        extentLogger.info("Enter username:"+ ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Enter password:"+ConfigurationReader.get("storemanager_password"));
        extentLogger.info("Click login button");

        new DashboardPage().navigateToModule("Activities", "Calendar Events");
        extentLogger.info("Navigate To Activities --> Calendar Events");

        wait.until(ExpectedConditions.titleIs("All - Calendar Events - Activities"));
        //BrowserUtils.waitFor(4);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        String expected = "25";
        String actual = calendarEventsPage.perPage.getText();

        //System.out.println("actual = " + actual);

        Assert.assertEquals(actual, expected, "Verify that view per page number is equals to '25'");
        extentLogger.pass("Test case #3 passed");


    }

    @Test
    public void testCase4() {
        extentLogger=report.createTest("Test case #4");
        loginPage.loginAsStoreManager();

        extentLogger.info("Enter username:"+ ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Enter password:"+ConfigurationReader.get("storemanager_password"));
        extentLogger.info("Click login button");

        new DashboardPage().navigateToModule("Activities", "Calendar Events");
        extentLogger.info("Navigate to Activities --> Calendar Events");
        wait.until(ExpectedConditions.titleIs("All - Calendar Events - Activities"));
        //BrowserUtils.waitFor(4);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        BrowserUtils.waitFor(3);
        String pageSize = driver.findElement(By.xpath("//div//label[@class=\"dib\"][2]")).getText();
        String[] totalPage = pageSize.split(" ");
        int totpage = Integer.parseInt(totalPage[1]);
        extentLogger.info("Get the total page number");
        String perpageNum = calendarEventsPage.perPage.getText();
        int perpage = Integer.parseInt(perpageNum);
        extentLogger.info("Get the view per page number");
        BrowserUtils.setAttribute(calendarEventsPage.pageNumber, "value", totalPage[1]);
        calendarEventsPage.pageNumber.sendKeys(Keys.ENTER);
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Go to last page of the events");
        List<WebElement> elementList = driver.findElements(By.xpath("//tbody/tr"));
        int totalRow = ((totpage - 1) * perpage) + elementList.size();
        extentLogger.info("Get the expected records result");

        String records = driver.findElement(By.xpath("//div//label[@class=\"dib\"][3]")).getText();
        String[] totrecords = records.split(" ");
        int totalRecords = Integer.parseInt(totrecords[2]);
        extentLogger.info("Get the actual records result");

        Assert.assertEquals(totalRecords, totalRow, "Verify that number of calendar events (rows in the table) is equals to number of records");
        extentLogger.pass("Test case #4 passed");

    }

    @Test
    public void testCase5() {
        extentLogger=report.createTest("Test case #5");
        loginPage.loginAsStoreManager();

        extentLogger.info("Enter username:"+ ConfigurationReader.get("storemanager_username"));
        extentLogger.info("Enter password:"+ConfigurationReader.get("storemanager_password"));
        extentLogger.info("Click login button");

        new DashboardPage().navigateToModule("Activities", "Calendar Events");
        extentLogger.info("Navigate to Activities --> Calendar Events");

        wait.until(ExpectedConditions.titleIs("All - Calendar Events - Activities"));
        //BrowserUtils.waitFor(4);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        driver.findElement(By.cssSelector("button>input[type=\"checkbox\"]")).click();
        extentLogger.info("Click and select all");
        WebElement firstCheckBox = driver.findElement(By.xpath("//tbody/tr[1]/td/input"));
        //System.out.println(firstCheckBox.isSelected());
        Assert.assertTrue(firstCheckBox.isSelected(), "verify that first calendar event selected");
        extentLogger.info("Check the first events selected");

        String pageSize = driver.findElement(By.xpath("//div//label[@class=\"dib\"][2]")).getText();
        String[] totalPage = pageSize.split(" ");
        BrowserUtils.setAttribute(calendarEventsPage.pageNumber, "value", totalPage[1]);
        calendarEventsPage.pageNumber.sendKeys(Keys.ENTER);
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        extentLogger.info("Go to last records page");
        List<WebElement> checkBoxList = driver.findElements(By.xpath("//tbody/tr/td/input"));

        for (WebElement element : checkBoxList) {
            // System.out.println(element.isSelected());
            Assert.assertTrue(element.isSelected(), "verify that last pages calendar event selected");
        }
        extentLogger.info("Check the last pages events selected");
        extentLogger.pass("Test case #5 passed");


    }
    @Test
    public void testCase6() {
        loginPage.loginAsStoreManager();

        new DashboardPage().navigateToModule("Activities","Calendar Events");
        wait.until(ExpectedConditions.titleIs("All - Calendar Events - Activities"));
        //BrowserUtils.waitFor(4);
        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        WebElement filterIcon = driver.findElement(By.cssSelector("[title=\"Filters\"]"));
        actions.moveToElement(filterIcon).click().perform();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        WebElement titleFilter = driver.findElement(By.xpath("//*[@class=\"filter-items\"]/div[1]/div[1]"));
        actions.moveToElement(titleFilter).click().perform();
        WebElement containsFilter = driver.findElement(By.xpath("//*[@class=\"filter-items\"]/div[1]/div[2]//input[1]"));
        containsFilter.sendKeys("Testers meeting");
        driver.findElement(By.xpath("//*[@class=\"filter-items\"]/div[1]/div[2]//button[@type=\"button\"]")).click();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).click();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);
        List<String> expectedTitles= Arrays.asList("Title","Description","Start","End","All-day Event","Organizer","Guests","Recurrence","Call Via Hangout");
        List<String> expectedInfos=Arrays.asList("Testers meeting","This is a a weekly testers meeting","Nov 27, 2019, 9:30 AM",
                "Nov 27, 2019, 10:30 AM","No","Stephan Haley","Tom Smith","Weekly every 1 week on Wednesday","No");

        List<WebElement> titles = driver.findElements(By.cssSelector("div[class=\"control-group attribute-row\"]>label"));
        List<String> actualTitles=BrowserUtils.getElementsText(titles);
        System.out.println(actualTitles);
        List<WebElement> infos = driver.findElements(By.cssSelector("div[class=\"controls\"]>div"));
        List<String> actualInfos=BrowserUtils.getElementsText(infos);
        System.out.println(actualInfos);

        Assert.assertEquals(actualTitles,expectedTitles,"Verify that titles");
        Assert.assertEquals(actualInfos,expectedInfos,"Verify that info's");


    }


}



