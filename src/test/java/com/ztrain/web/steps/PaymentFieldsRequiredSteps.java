package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.HomePage;
import io.cucumber.java.en.Then;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class PaymentFieldsRequiredSteps {

    private HomePage homePage;

    public PaymentFieldsRequiredSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Then("^A required fields error message should appear under the fields (.*) (.*)$")
    public void aRequiredFieldsErrorMessageShouldAppearUnderTheFieldsCardAddress(String card, String address) {
        System.out.println(homePage.addressErrorMessage());
        System.out.println(address);
        assertTrue(card.contains(homePage.cardErrorMessage()));
        //assertTrue(address.contains(homePage.addressErrorMessage()));
    }
}
