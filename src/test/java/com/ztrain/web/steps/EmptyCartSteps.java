package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertEquals;

public class EmptyCartSteps {

    private HomePage homePage;

    public EmptyCartSteps(HomePage homePage) {
        this.homePage = homePage;
    }
    @When("user clicks again on cart icon")
    public void userClicksAgainOnCartIcon() {
        homePage.openCart();
    }

    @And("he clicks on empty cart button")
    public void heClicksOnEmptyCartButton() {
        homePage.emptyCart();
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        assertEquals("0", homePage.cartValue());
    }
}
