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

public class TC10 extends TestBase {

    @Test
    public void After() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);

        DashboardPage dashboardPage=new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(3);

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        allCalendarEvents.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitFor(10);
        //BrowserUtils.waitForClickablility(By.xpath("[id^='recurrence-repeats-view']"), 10);

        createCalendarEventsPage.repeat.click();
        Thread.sleep(3000);
        createCalendarEventsPage.after.click();
        Thread.sleep(3000);

        createCalendarEventsPage.Occurance.sendKeys("10");

        Thread.sleep(3000);

        createCalendarEventsPage.Summary.click();

        String fMsg = createCalendarEventsPage.Summary.getText();
        String sMsg = createCalendarEventsPage.Message.getText();
        String tMsg = createCalendarEventsPage.DynamicMessage.getText();

        String ttlmsg = fMsg+" "+sMsg+tMsg;

        Assert.assertEquals((fMsg+" " +sMsg+tMsg), "Summary: Daily every 1 day, end after 10 occurrences", " Verify that the actual message matches with expected");
    }


}
