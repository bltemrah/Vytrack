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

import java.util.ArrayList;
import java.util.List;

public class TC8 extends TestBase {


    @Test
    public void Repeat() throws InterruptedException {

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

        List<String> ExpectedMenu = new ArrayList<>();
        ExpectedMenu.add("Daily");
        ExpectedMenu.add("Weekly");
        ExpectedMenu.add("Monthly");
        ExpectedMenu.add("Yearly");


        BrowserUtils.waitFor(5);

        List<String> rMenu = createCalendarEventsPage.repeatMenu();

        //List<WebElement> rMenu = createCalendarEventsPage.repeatOptionsList().getOptions();

        for (int i = 0; i < rMenu.size(); i++) {

            Assert.assertEquals(rMenu.get(i), ExpectedMenu.get(i), "Verify that actual matches expected");
        }

        BrowserUtils.waitFor(5);
        Thread.sleep(3000);
        Assert.assertTrue(createCalendarEventsPage.Daily.isDisplayed());
    }
}