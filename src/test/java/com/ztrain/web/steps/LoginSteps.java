package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.HomePage;
import com.ztrain.web.pageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class LoginSteps {

    private LoginPage loginPage;
    private HomePage homePage;

    public LoginSteps(LoginPage loginPage, HomePage homePage) {
        this.loginPage = loginPage;
        this.homePage = homePage;
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

    @Given("^user is at login page$")
    public void userIsAtTheLoginPage() {
        loginPage.goToLoginPage();
    }

    @When("^user is logging-in with (.*) (.*)$")
    public void userIsLoggingInWithUsernamePassword(String email, String password) {
        loginPage.fillLoginForm(email, password);
        loginPage.clickOnConnexionButton();
    }

    @Then("^he should be redirected to the home page$")
    public void heShouldBeAtTheHomePage() {
        assertTrue(homePage.isZtrainLogoDisplayed(), "This is not the passage");
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

    @When("user fill in the password field {string}")
    public void userFillInThePasswordField(String password) {
        loginPage.sendKeysSlowly(loginPage.passwordInput, password);
    }

    @And("User clicks on the display password button to the right of the password field")
    public void userClicksOnTheDisplayPasswordButtonToTheRightOfThePasswordField() {
        loginPage.clickOnEyeButton();
    }

    @Then("The password is displayed in clear")
    public void thePasswordIsDisplayedInClear() {
        Assert.assertEquals(loginPage.passwordInput.getAttribute("type"), "text");
    }
}
