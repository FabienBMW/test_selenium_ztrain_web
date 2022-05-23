package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPasswordRequiredSteps {

    public LoginPage loginPage;

    public LoginPasswordRequiredSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @When("User clicks on connexion button without filling in the login and password fields")
    public void userClickOnConnexionButtonWithoutFillingInTheLoginAndPasswordFields() {
        loginPage.clickOnConnexionButton();
    }

    @Then("User should see an error message below the login and password fields")
    public void userShouldSeeAnErrorMessageBelowTheLoginAndPasswordFields() {
        assertTrue("No error message displayed", loginPage.checkLoginErrorMessage());
    }
}
