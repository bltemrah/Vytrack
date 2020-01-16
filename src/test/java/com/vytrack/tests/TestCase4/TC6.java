package com.vytrack.tests.TestCase4;

import com.vytrack.pages.AllCalendarEvents;
import com.vytrack.pages.CreateCalendarEventsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC6 extends TestBase {


    @Test
    public void TimeDifference() {

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);

        BrowserUtils.waitFor(5);

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitFor(5);

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        allCalendarEvents.createCalendarEvent.click();

        BrowserUtils.waitFor(5);

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.time_1Box.click();
        createCalendarEventsPage.NinePm.click();

        BrowserUtils.waitFor(5);

        String secondBox = createCalendarEventsPage.time_2Box.getAttribute("value");
        System.out.println(secondBox);

        BrowserUtils.waitFor(5);

        Assert.assertEquals(secondBox, "10:00 PM", "Verify that actual is 10:00 PM");


    }

}

