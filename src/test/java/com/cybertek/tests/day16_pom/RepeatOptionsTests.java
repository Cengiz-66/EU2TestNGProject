package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.CreateCalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatOptionsTests extends TestBase {

    /*VERIFY RADIO BUTTONS
    Open browser
    Login as driver
    Go to Activities->Calendar Events
    Click on create calendar events
    Click on repeat
    Verify that repeat every days is checked
    verify that repeat weekday is not checked
    * */
    LoginPage loginPage=new LoginPage();
    @Test
    public void test() {

        loginPage.loginAsDriver();

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities","Calendar Events");

        CalendarEventsPage calendarEventsPage=new CalendarEventsPage();
        dashboardPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Assert.assertTrue(createCalendarEventsPage.days.isSelected(),"Verify days rb is checked");
        Assert.assertFalse(createCalendarEventsPage.weekday.isSelected(),"Verify weekday is NOT checked");
        createCalendarEventsPage.save.click();

    }

    @Test
    public void test2() {

        /*
    VERIFY REPEAT OPTIONS
    Open browser
    Login as driver
    Go to Activities->Calendar
    Click on create calendar events
    Click on repeat
    Verify that repeat options are Daily, Weekly, Monthly,Yearly(in this order)
    */
        loginPage.loginAsDriver();
        new DashboardPage().navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.repeat.click();

        Select repeatDropdown = createCalendarEventsPage.repeatOptionsList();

        List<String> expectedList = Arrays.asList("Daily", "Weekly", "Monthly", "Yearly");

        List<WebElement> actualOptions = repeatDropdown.getOptions();
        List<String> actualList = new ArrayList<>();

     /*   for (WebElement option : actualOptions) {

            actualList.add(option.getText());
        }

      */

     //getting list with ready method
        actualList=BrowserUtils.getElementsText(actualOptions);
        System.out.println("actualList = " + actualList);

        Assert.assertEquals(actualList,expectedList,"verify dropdown options");
        createCalendarEventsPage.save.click();

        }


    }
