package com.Fleetgru.stepdefinitions;

import com.Fleetgru.pages.DashboardPage;
import com.Fleetgru.utilities.BrowserUtils;
import com.Fleetgru.utilities.ConfigurationReader;
import com.Fleetgru.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutStepDef {

    @When("user clicks profile menu dropdown")
    public void user_clicks_profile_menu_dropdown() {
        BrowserUtils.waitFor(1);
        new DashboardPage().profileDropDown.click();
    }

    @When("clicks {string}")
    public void clicks(String option) {
        BrowserUtils.waitFor(1);
        new DashboardPage().ProfileMenuOptions(option).click();
    }

    @Then("user should land on login page successfully")
    public void user_should_land_on_login_page_successfully() {
        BrowserUtils.waitFor(2);
        String ActualTitle = Driver.get().getTitle();
        String ExpectedTitle = "Login";
        Assert.assertEquals("Verify titles", ExpectedTitle, ActualTitle);
    }

    @And("user clicks step back button")
    public void userClicksStepBackButton() {
        Driver.get().navigate().back();
    }

    @Then("user should not be able to go to home page again")
    public void userShouldNotBeAbleToGoToHomePageAgain() {
        BrowserUtils.waitFor(1);
        String ActualTitle = Driver.get().getTitle();
        String ExpectedTitle = "Login";
        Assert.assertEquals("Verify titles", ExpectedTitle, ActualTitle);
    }

    @And("user close the window")
    public void userCloseTheWindow() {
        Driver.get().quit();
    }


    @And("user navigates to Fleetgru website")
    public void userNavigatesToFleetgruWebsite() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(ConfigurationReader.get("url"));
        driver.close();
    }

    @Then("user should land on login page")
    public void userShouldLandOnLoginPage() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(1);
        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Login";
        Assert.assertEquals("Verify login page", ExpectedTitle, ActualTitle);
        driver.close();
    }

    @And("user opens new tabs")
    public void userOpensNewTabs() {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.open('https://qa.fleetgru.com/', '_blank');");
        BrowserUtils.waitFor(2);
        jse.executeScript("window.open('https://qa.fleetgru.com/', '_blank');");
        BrowserUtils.waitFor(2);
        jse.executeScript("window.open('https://www.google.com/', '_blank');");
        BrowserUtils.waitFor(2);

    }
}
