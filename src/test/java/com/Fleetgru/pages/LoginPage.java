package com.Fleetgru.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(css = "#prependedInput")
    public WebElement usernameBox;

    @FindBy(css = "#prependedInput2")
    public WebElement passwordBox;

    @FindBy(css = "#_submit")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(text(),'Invalid user name or password.')]")
    public WebElement invalidMessage;

    @FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
    public WebElement ForgotPasswordLink;

    @FindBy(xpath = "//span[contains(text(),'Remember me on this computer')]")
    public WebElement RememberMeLink;

    @FindBy(xpath = "//input[@id='remember_me']")
    public WebElement RememberMeCheckBox;

}
