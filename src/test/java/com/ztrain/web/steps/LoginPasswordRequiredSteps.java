package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPasswordRequiredSteps {

    public LoginPage loginPage;

    public LoginPasswordRequiredSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @When("User clicks on connexion button without filling in the login and password fields")
    public void userClickOnConnexionButtonWithoutFillingInTheLoginAndPasswordFields() {
        loginPage.clickOnConnexionButton();
    }

    @Then("^User should see an error message below the login and password fields (.*) (.*)$")
    public void userShouldSeeAnErrorMessageBelowTheLoginAndPasswordFields(String emailMessage, String passwordMessage) {
        System.out.println(loginPage.emailErrorMessage());
        System.out.println(emailMessage);
        assertEquals(emailMessage, loginPage.emailErrorMessage());
        //assertEquals(passwordMessage, loginPage.passwordErrorMessage());
    }
}
