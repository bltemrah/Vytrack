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

public class TC9 extends TestBase {


    @Test
    public void Never() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);

        BrowserUtils.waitFor(5);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitFor(5);

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        allCalendarEvents.createCalendarEvent.click();

        BrowserUtils.waitFor(5);

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        createCalendarEventsPage.repeat.click();

        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        Assert.assertTrue(createCalendarEventsPage.repeat.isSelected());

        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        Assert.assertTrue(createCalendarEventsPage.RepeatEvery.isSelected());

        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        Assert.assertTrue(createCalendarEventsPage.EndsNever.isSelected());

        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        String sMsg = createCalendarEventsPage.Message.getText();

        Assert.assertEquals(sMsg, "Daily every 1 day");

    }
}