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

import java.util.List;

public class TC5 extends TestBase {

    @Test
    public void watch() throws InterruptedException {

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);

        BrowserUtils.waitFor(3);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        dashboardPage.waitUntilLoaderScreenDisappear();

        BrowserUtils.waitFor(3);

        AllCalendarEvents allCalendarEvents = new AllCalendarEvents();
        allCalendarEvents.createCalendarEvent.click();

        BrowserUtils.waitFor(3);

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();

        createCalendarEventsPage.time_1Box.click();

        BrowserUtils.waitFor(5);

        createCalendarEventsPage.TimeSelection.click();
        BrowserUtils.waitFor(5);

        List<String> timeList1 = createCalendarEventsPage.timeStart1();

        String time1 = timeList1.get(4);


//        public List<String> timeStart1() {
//
//            List<WebElement> timeMenu = Driver.get().findElements(By.xpath("(//ul[@class ='ui-timepicker-list'])[1]/li"));
//
//            List<String> timeItem = new ArrayList<>();
//
//            for (int i = 0; i < timeMenu.size(); i++) {
//                WebElement element1=timeMenu.get(i);
//                String box1=element1.getAttribute("innerHTML");
//                timeItem.add(box1.substring(0,5));
//            }
//            return timeItem;
//        }

        String[] array = time1.split(":");
        String firstHour = array[0].concat(array[1]);
        System.out.println("firstHour = " + firstHour);
        double FirstBoxTime = Double.parseDouble(firstHour);
        System.out.println("firstHourInteger = " + FirstBoxTime);

        BrowserUtils.waitFor(5);

        createCalendarEventsPage.time_2Box.click();

        String time2 = createCalendarEventsPage.TestBox2Options();

//        public String TestBox2Options () {
//
//            List<WebElement> timeMenu = Driver.get().findElements(By.xpath("(//ul[@class ='ui-timepicker-list'])[2]/li"));
//            String time2 = "";
//
//            for (int i = 0; i < timeMenu.size(); i++) {
//                WebElement option2 = timeMenu.get(i);
//                String time = option2.getAttribute("class");
//
//                if (time.contains("ui-timepicker-selected")) {
//                    time2 = option2.getAttribute("innerHTML").substring(0, 4);
//                    break;
//                } else {
//                    time2 = time2;
//                }
//            }
//            return time2;
//        }


        String[] array2 = time2.split(":");

        String secHour = array2[0].concat(array2[1]);
        System.out.println("secHour = " + secHour);
        double SecondBoxTime = Double.parseDouble(secHour);
        System.out.println("SecondBoxTime = " + SecondBoxTime);

        double difference = SecondBoxTime - FirstBoxTime;

        System.out.println("difference = " + difference);

        Assert.assertEquals(difference, 100, "Verify that difference equals 100");


    }

}
