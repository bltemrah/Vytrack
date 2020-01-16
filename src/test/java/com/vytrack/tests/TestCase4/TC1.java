package com.vytrack.tests.TestCase4;

import com.vytrack.pages.AllCalendarEvents;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TC1 extends TestBase {

    @Test
    public void ThreeDots() throws InterruptedException {

        extentLogger = report.createTest("ThreeDotsMenu");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        BrowserUtils.waitFor(2);
        String password = ConfigurationReader.get("storemanager_password");
        extentLogger.info("username: "+username);
        extentLogger.info("password: "+password);
        extentLogger.info("Login as a Store manager");
        BrowserUtils.waitFor(2);
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        extentLogger.info("Navigate to Activities -- Calendar Events");
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(2);

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        extentLogger.info("Click on ThreeDots");
        BrowserUtils.waitFor(2);
        action.clickAndHold(allCalendarEvents.ThreeDots).perform();

        Thread.sleep(3000);

        List<String> expectedMenu = Arrays.asList("Vie", "Edit", "Delete");

        BrowserUtils.waitFor(5);

        List<String> scMenu = allCalendarEvents.GridMenu();

        extentLogger.info("Verify Three Dots have View, Edit and Delete");

        for (int i = 0; i < expectedMenu.size(); i++) {

            Assert.assertEquals(scMenu.get(i), expectedMenu.get(i), "Verify that actual matches expected");
        }


    }

}
