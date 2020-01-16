package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CreateCalendarEventsPage extends BasePage {

    public CreateCalendarEventsPage(){

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

    @FindBy(css = "[id^='recurrence-repeats-view']")
    public WebElement repeatOptions;

    public Select repeatOptionsList(){

        return new Select(repeatOptions);
    }


    public List<String>  repeatMenu() {

        List<WebElement> timeMenu = Driver.get().findElements(By.xpath("//select[@data-name='recurrence-repeats']//option"));
        List<String> timeItem2 = new ArrayList<>();

        for (WebElement each : timeMenu) {
            timeItem2.add(each.getText());
        }
        return timeItem2;
    }




    @FindBy(className = "select2-chosen")
    public WebElement selectedOwner;

    @FindBy(css = "input[id^='oro_calendar_event_form_title-']")
    public WebElement title;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    public WebElement startDate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    public WebElement endDate;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start']")
    public WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end']")
    public WebElement endTime;

    @FindBy(xpath = "(//input[@type='radio'])[1]")
    public WebElement days;

    @FindBy(xpath = "(//input[@type='radio'])[2]")
    public WebElement weekday;

    @FindBy(xpath = "(//input[@type='radio'])[3]")
    public WebElement never;

    @FindBy(xpath = "(//input[@type='radio'])[4]")
    public WebElement after;

    @FindBy(xpath = "(//input[@type='radio'])[5]")
    public WebElement by;

    @FindBy(xpath = "(//input[@type = 'text'])[16]")
    public WebElement Occurance;

    @FindBy(xpath = "//span[contains(text(),'Daily every 1 day')]")
    public WebElement Message;

    @FindBy(xpath = "//span[contains(text(),', end after 10 occurrences')]")
    public WebElement DynamicMessage;

    @FindBy(xpath = "//label[contains(text(),'Summary:')]")
    public WebElement Summary;

    @FindBy (xpath = "//a[@class='btn-success btn dropdown-toggle']")
    public WebElement SaveAndClose;

    public List<String> SaveAndCloseMenu() {

        List<WebElement> SaveMenu = Driver.get().findElements(By.xpath("(//ul[@class='dropdown-menu'])[3]/li"));

        List<String> saveItem = new ArrayList<>();

        for (WebElement each : SaveMenu) {
            saveItem.add(each.getText());
        }
        return saveItem;
    }

    @FindBy(xpath = "//a[@title = 'Cancel']")
    public WebElement CancelButton;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement AllCalendarEvents;
    //or
    @FindBy(css="[class='oro-subtitle']")
    public WebElement AllEventSub;

    @FindBy(xpath = "(//input[@placeholder='time'])[1]")
    public WebElement time_1Box;

    public List<String> timeStart1() {

        List<WebElement> timeMenu = Driver.get().findElements(By.xpath("(//ul[@class ='ui-timepicker-list'])[1]/li"));

        List<String> timeItem = new ArrayList<>();

        for (int i = 0; i < timeMenu.size(); i++) {
            WebElement element1=timeMenu.get(i);
            String box1=element1.getAttribute("innerHTML");
            timeItem.add(box1.substring(0,5));
        }
        return timeItem;
    }

    @FindBy(xpath = "(//input[@placeholder='time'])[2]")
    public WebElement time_2Box;

    @FindBy(xpath = "(//li[@class ='ui-timepicker-pm ui-timepicker-selected'])[2]")
    public WebElement TimeSelectionBox2;

    public String TestBox2Options() {

        List<WebElement> timeMenu = Driver.get().findElements(By.xpath("(//ul[@class ='ui-timepicker-list'])[2]/li"));
        String time2 = "";

        for (int i = 0; i < timeMenu.size(); i++) {
            WebElement option2 = timeMenu.get(i);
            String time = option2.getAttribute("class");

            if(time.contains("ui-timepicker-selected")){
                time2 = option2.getAttribute("innerHTML").substring(0,4);
            } else {
                time2 = time2;
            }
        }
        return time2;
    }
    public String timeEnd() {

        List<WebElement> timeMenu = Driver.get().findElements(By.xpath("(//ul[@class ='ui-timepicker-list'])[2]/li"));
        //List<String> timeItem2 = new ArrayList<>();
        String time2 = "";

        for (int i = 0; i < timeMenu.size(); i++) {
            WebElement element2 = timeMenu.get(i);
            String time = element2.getAttribute("innerHTML");

            if(time.substring(0,4).contains("3:00")) {
                time2 = time.substring(0,4);
            } else {
                time2 = time2;
            }
        }
        return time2;
    }

    @FindBy(xpath = "(//ul[@class ='ui-timepicker-list'])[1]/li[5]")
    public WebElement TimeSelection;

    @FindBy(xpath = "(//ul[@class ='ui-timepicker-list'])[1]/li[43]")
    public WebElement NinePm;

    @FindBy(xpath = "//input[@data-name = 'field__all-day']")
    public WebElement AllDayEvent;


    @FindBy(xpath = "[id^='recurrence-repeats-view']")
    public WebElement repeatMenu;

    @FindBy(xpath = "//option[contains(text(),'Daily')]")
    public WebElement Daily;

    @FindBy(xpath = "//input[@type = 'radio'][1]")
    public WebElement RepeatEvery;

    @FindBy(xpath = "(//input[@type = 'radio'])[3]")
    public WebElement EndsNever;

    @FindBy(xpath = "(//input[@type = 'radio'])[5]")
    public WebElement Byclick;

    @FindBy(xpath = "(//input[@placeholder= 'Choose a date'])[3]")
    public WebElement ChooseDate;

    @FindBy(xpath = "//select[@data-handler = 'selectYear']")
    public WebElement SelectYear;

    @FindBy(xpath = "//select[@data-handler = 'selectYear']//option[2]")
    public WebElement Year2021;

    @FindBy(xpath = "//select[@data-handler = 'selectMonth']")
    public WebElement SelectMonth;

    @FindBy(xpath = "//select[@data-handler = 'selectMonth']//option[11]")
    public WebElement MonthNov;

    @FindBy(xpath = "//a[text() = '18']")
    public WebElement Nov18;

    @FindBy(xpath = "//span[contains(text(),'Daily every 1 day')]")
    public WebElement fMessage;

    @FindBy(xpath = "//span[contains(text(),', end by Nov 18, 2021')]")
    public WebElement sMessage;

    @FindBy(xpath = "(//option[@value = 'weekly'])[1]")
    public WebElement Rweekly;

    @FindBy(xpath = "//input[@value = 'monday']")
    public WebElement Wmonday;

    @FindBy(xpath = "//input[@value = 'friday']")
    public WebElement Wfriday;

    @FindBy(xpath = "//span[contains(text(),'Weekly every 1 week on Monday, Friday')]")
    public WebElement Wmsg1;


    public List<String>  DateSelection() {

        List<WebElement> timeMenu = Driver.get().findElements(By.xpath("//select[@data-handler = 'selectYear']//option"));
        List<String> timeItem2 = new ArrayList<>();

        for (WebElement each : timeMenu) {
            timeItem2.add(each.getText());
        }
        return timeItem2;

    }



}