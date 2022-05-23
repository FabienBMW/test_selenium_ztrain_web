package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.*;

public class PasswordInClearSteps {

    private LoginPage loginPage;

    public PasswordInClearSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
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
        assertEquals(loginPage.passwordInput.getAttribute("type"), "text");
    }
}
