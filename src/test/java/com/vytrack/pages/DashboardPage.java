package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    //no need to explicitly write constructors, because it will use its parents constructor.
    public DashboardPage(){

        PageFactory.initElements(Driver.get(),this);
    }




}
