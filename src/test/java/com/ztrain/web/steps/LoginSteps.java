package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.HomePage;
import com.ztrain.web.pageObjects.LoginPage;
import io.cucumber.java.en.*;

import static org.testng.Assert.assertTrue;

public class LoginSteps {

    private LoginPage loginPage;
    private HomePage homePage;

    public LoginSteps(LoginPage loginPage, HomePage homePage) {
        this.loginPage = loginPage;
        this.homePage = homePage;
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

    //        @Then("^he should(|n't) be redirected to the home page$")
    @Then("^he should be redirected to the home page$")
    public void heShouldBeAtTheHomePage() {
            /*if (negation.isEmpty()) {
                assertTrue(homePage.isZtrainLogoDisplayed());
                return;
            }
            Assert.assertNotEquals(homePage.getTitle(), "Intranet Zenity");*/

        assertTrue(homePage.isZtrainLogoDisplayed(), "This is not the passage");
        //homePage.saveScreenShotPNG();
    }
}
