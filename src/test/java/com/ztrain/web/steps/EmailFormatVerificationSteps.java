package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class EmailFormatVerificationSteps {

    private LoginPage loginPage;

    public EmailFormatVerificationSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }
    @And("^user fills the email's field with value (.*)$")
    public void userFillsTheEmailSFieldWithValueEmail(String email) {
        loginPage.fillEmailField(email);
    }

    @When("user clicks on submit button")
    public void userClicksOnSubmitButton() {
        loginPage.clickOnConnexionButton();
    }

    @Then("^An error appears to report invalid email syntax (.*)$")
    public void anErrorAppearsToReportInvalidEmailSyntax(String message) {
        System.out.println(loginPage.emailErrorMessage());
        System.out.println(message);
        assertEquals(message, loginPage.emailErrorMessage());
    }
}
