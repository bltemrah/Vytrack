package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class AllCalendarEvents extends BasePage {

    public AllCalendarEvents() {

        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']//td[.='Testers meeting']/../td[9]")
    public WebElement ThreeDots;

    @FindBy(xpath = "//div[@class = 'column-manager dropdown']")
    public WebElement Grid;

    public List<String> GridMenu() {

        List<WebElement> SaveMenu = Driver.get().findElements(By.xpath("//ul[@class = 'nav nav-pills icons-holder launchers-list']//li/a"));

        List<String> saveItem = new ArrayList<>();

        for (WebElement each : SaveMenu) {
            saveItem.add(each.getAttribute("title"));
        }
        return saveItem;
    }

    @FindBy(xpath = "(//span[@class = 'grid-header-cell__label'])[1]")
    public WebElement TitleColumn;

    public void GridSetting(int firstIndex, int lastIndex) {

        List<WebElement> grids = Driver.get().findElements(By.xpath("//tr//td[3]"));

        for (int i = firstIndex; i <= lastIndex; i++) {
            grids.get(i).click();
        }
    }


}


