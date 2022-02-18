package com.Fleetgru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends  BasePage{

    @FindBy(css = ".oro-subtitle")
    public WebElement subtitle;

    @FindBy(xpath = "//header/div[1]/div[1]/ul[1]/li[4]/a[1]")
    public WebElement profileDropDown;
}
