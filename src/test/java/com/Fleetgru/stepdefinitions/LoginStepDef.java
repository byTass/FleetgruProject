package com.Fleetgru.stepdefinitions;

import com.Fleetgru.pages.DashboardPage;
import com.Fleetgru.pages.LoginPage;
import com.Fleetgru.utilities.BrowserUtils;
import com.Fleetgru.utilities.ConfigurationReader;
import com.Fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginStepDef {

    @When("user navigates to Fleetgru login page")
    public void user_navigates_to_Fleetgru_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(1);
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        new LoginPage().usernameBox.sendKeys(username);
        new LoginPage().passwordBox.sendKeys(password);
    }

    @When("clicks login button")
    public void clicks_login_button() {
        new LoginPage().loginButton.click();
        BrowserUtils.waitForPageToLoad(10);
    }

    @Then("user lands on {string} page successfully")
    public void user_lands_on_page_successfully(String ExpectedSubtitle) {
        BrowserUtils.waitFor(1);
        String ActualSubtitle = new DashboardPage().subtitle.getText();
        Assert.assertEquals("Verify subtitles are equal", ExpectedSubtitle, ActualSubtitle);
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String ExpectedMessage) {
        BrowserUtils.waitFor(2);
        String ActualMessage = new LoginPage().invalidMessage.getText();
        Assert.assertEquals("Invalid username or password.", ExpectedMessage, ActualMessage);
    }

    @Then("{string} warning should be displayed under Username Box")
    public void warningShouldBeDisplayedUnderUsernameBox(String ExpectedMessage) {
        BrowserUtils.waitFor(1);
        String ActualMessage = new LoginPage().usernameBox.getAttribute("validationMessage");
        Assert.assertEquals("Verify Validation Message", ExpectedMessage, ActualMessage);
    }

    @Then("{string} warning should be displayed under Password Box")
    public void warningShouldBeDisplayedUnderPasswordBox(String ExpectedMessage) {
        BrowserUtils.waitFor(1);
        String ActualMessage = new LoginPage().passwordBox.getAttribute("validationMessage");
        Assert.assertEquals("Verify Validation Message", ExpectedMessage, ActualMessage);
    }

    @When("user clicks Forgot Your Password link")
    public void userClicksForgotYourPasswordLink() {
        new LoginPage().ForgotPasswordLink.click();
        BrowserUtils.waitForPageToLoad(5);
    }

    @Then("user lands on Forgot Password page")
    public void userLandsOnForgotPasswordPage() {
        String ActualTitle = Driver.get().getTitle();
        String ExpectedTitle = "Forgot Password";
        Assert.assertEquals("Verify title", ExpectedTitle, ActualTitle);
    }

    @When("user sees Remember me on this computer link")
    public void userSeesRememberMeOnThisComputerLink() {
        Assert.assertTrue(new LoginPage().RememberMeLink.isDisplayed());
    }

    @Then("user should be able to click")
    public void userShouldBeAbleToClick() {
        new LoginPage().RememberMeLink.click();
        BrowserUtils.waitFor(1);
        Assert.assertTrue(new LoginPage().RememberMeCheckBox.isSelected());
    }

    @Then("user should see password in bullet sign")
    public void userShouldSeePasswordInBulletSign() {
        BrowserUtils.waitFor(1);
        Assert.assertTrue(new LoginPage().passwordBox.getAttribute("type").equals("password"));
    }

    @When("user enters {string} and {string} clicks Enter via keyboard")
    public void userEntersAndClicksEnterViaKeyboard(String username, String password) {
        new LoginPage().usernameBox.sendKeys(username + Keys.ENTER);
        new LoginPage().passwordBox.sendKeys(password + Keys.ENTER);
    }

    @Then("users see their own {string} in the profile menu")
    public void usersSeeTheirOwnInTheProfileMenu(String ExpectedName) {
        String ActualName = new DashboardPage().profileDropDown.getText();
        Assert.assertEquals("Verify name", ExpectedName, ActualName);
    }
}
