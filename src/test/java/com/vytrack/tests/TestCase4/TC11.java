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

public class TC11 extends TestBase {

    @Test
    public void CalendarCheck() throws InterruptedException {

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

        createCalendarEventsPage.Byclick.click();

        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        createCalendarEventsPage.ChooseDate.click();

        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        createCalendarEventsPage.SelectYear.click();

        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        createCalendarEventsPage.Year2021.click();
        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        createCalendarEventsPage.SelectMonth.click();
        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        createCalendarEventsPage.MonthNov.click();
        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        createCalendarEventsPage.Nov18.click();
        BrowserUtils.waitFor(5);
        Thread.sleep(3000);

        String summary = createCalendarEventsPage.Summary.getText();
        String fMsg = createCalendarEventsPage.fMessage.getText();
        String sMsg = createCalendarEventsPage.sMessage.getText();

        Assert.assertEquals(summary + " " + fMsg + sMsg, "Summary: Daily every 1 day, end by Nov 18, 2021");




//        List<String> dateSelection = createCalendarEventsPage.DateSelection();
//
//        for (int i= 0; i<dateSelection.size() ; i++) {
//            if(dateSelection.get(i).equalsIgnoreCase("2021")) {
//                dateSelection.get(i).
//            }
//        }



    }
}