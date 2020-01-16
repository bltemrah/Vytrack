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

public class TC3 extends TestBase {

    @Test
    public void SaveAndClode() throws InterruptedException {
        extentLogger = report.createTest("Save And Close Menu");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        BrowserUtils.waitFor(1);
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a Store manager");
        BrowserUtils.waitFor(2);
        loginPage.login(username, password);

        DashboardPage dashboardPage=new DashboardPage();
        extentLogger.info("Navigate to Activities -- Calendar Events");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        extentLogger.info("Create Calendar Event");
        allCalendarEvents.createCalendarEvent.click();

        BrowserUtils.waitFor(5);

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        extentLogger.info("Click Save and Close");
        createCalendarEventsPage.SaveAndClose.click();

        List<String> ExpectedMenu = new ArrayList<String>();

        ExpectedMenu.add("Save And Close");
        ExpectedMenu.add("Save And New");
        ExpectedMenu.add("Save");

        //List<String> expectedMenu = Arrays.asList("View", "Edit", "Delete");

        BrowserUtils.waitFor(5);
        extentLogger.info("Get all options in Save and Close Menu");
        List<String> scMenu = createCalendarEventsPage.SaveAndCloseMenu();

        extentLogger.info("Verify Save and Close menu");
        for(int i = 0; i<ExpectedMenu.size(); i++) {

            Assert.assertEquals(scMenu.get(i), ExpectedMenu.get(i), "Verify that actual matches expected");
        }


    }


}
