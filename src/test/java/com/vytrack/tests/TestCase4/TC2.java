package com.vytrack.tests.TestCase4;

import com.vytrack.pages.AllCalendarEvents;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;
public class TC2 extends TestBase {

    @Test
    public void Grid_Options() throws InterruptedException {

        extentLogger = report.createTest("Grid Options");
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
        extentLogger.info("Click on Grid Options");
        allCalendarEvents.Grid.click();
        BrowserUtils.waitFor(3);
        extentLogger.info("Unclick options in the Grid Menu");
        allCalendarEvents.GridSetting(1, 6);

        extentLogger.info("Verify Unclick Column and existing Title Column");
        Assert.assertTrue(allCalendarEvents.TitleColumn.isDisplayed());

    }

}