package com.cybertek.tests.day16_pom;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {

    /*Test case
    Open browser
    Login as a Driver
    Verify that page subtitle is Quick Launchpad
    Go to Activities -> Calendar Events
    verify that page subtitle is Calendar Events
    */

    LoginPage loginPage=new LoginPage();

    @Test
    public void test1() {
        loginPage.loginAsDriver();
        //Same with Thread.Sleep(3000)
        //BrowserUtils.waitFor(3);

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";
        String actualSubtitle = dashboardPage.getPageSubTitle();
        //System.out.println("actualSubtitle = " + actualSubtitle);
        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitles");

        String tab="Activities";
        String module="Calendar Events";
        dashboardPage.navigateToModule(tab,module);
        expectedSubtitle="Calendar Events";
        actualSubtitle=dashboardPage.getPageSubTitle();
        Assert.assertEquals(actualSubtitle,expectedSubtitle,"verify subtitles");




    }


}
