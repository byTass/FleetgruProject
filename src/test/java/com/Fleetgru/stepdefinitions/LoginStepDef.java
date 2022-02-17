package com.Fleetgru.stepdefinitions;

import com.Fleetgru.pages.DashboardPage;
import com.Fleetgru.pages.LoginPage;
import com.Fleetgru.utilities.BrowserUtils;
import com.Fleetgru.utilities.ConfigurationReader;
import com.Fleetgru.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

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


}
