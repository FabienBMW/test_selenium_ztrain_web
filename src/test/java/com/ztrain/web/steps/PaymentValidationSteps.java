package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class PaymentValidationSteps {

    private HomePage homePage;

    public PaymentValidationSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @And("^User fills fields with (.*), (.*), (.*) and (.*)$")
    public void userFillsFieldsWithCardNumberExpiredDateCvcAndAdresseDeLivraison(String cardNumber, String expirationDate, String cvc, String address) {
        homePage.fillPaymentForm(cardNumber, expirationDate, cvc, address);
    }

    @And("User sends the form")
    public void userSendsTheForm() {
        homePage.submitPaymentForm();
    }

    @Then("A validation confirmation message should appear on the screen")
    public void aValidationConfirmationMessageShouldAppearOnTheScreen() {
        assertFalse(homePage.paymentMessage().contains("Internal server error"));
    }
}
