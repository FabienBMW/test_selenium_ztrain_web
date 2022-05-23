package com.ztrain.web.steps;

import com.ztrain.web.driver.Driver;
import com.ztrain.web.pageObjects.HomePage;
import com.ztrain.web.pageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertTrue;

public class LogOutSteps {
    private HomePage homePage;
    private LoginPage loginPage;

    public LogOutSteps(HomePage homePage, LoginPage loginPage) {
        this.homePage = homePage;
        this.loginPage = loginPage;
    }

    @When("User clicks on Account icon")
    public void userClicksOnAccountIcon() {
        homePage.moveToAccountIcon();
    }

    @And("User clicks on disconnect")
    public void userClicksOnDisconnect() {
        System.out.println("in and");
        homePage.logOut();
    }

    @Then("User should be logged out")
    public void userShouldBeLoggedOut() {
        assertTrue(loginPage.driver.getCurrentUrl().contains("/auth/login"));
    }
}
