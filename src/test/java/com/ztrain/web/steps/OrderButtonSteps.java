package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.AssertJUnit.*;

public class OrderButtonSteps {
    private HomePage homePage;

    public OrderButtonSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @And("he clicks on cart icon")
    public void heClicksOnCartIcon() {
        homePage.openCart();
    }

    @And("User clicks on order button")
    public void userClicksOnOrderButton() {
        homePage.order();
    }

    @Then("The order validation pop-up should appear")
    public void theOrderValidationPopUpShouldAppear() {
        assertEquals("Valider votre commande", homePage.getOrderPopUpMessage());
    }
}
