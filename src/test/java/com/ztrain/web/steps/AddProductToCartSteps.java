package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertEquals;

public class AddProductToCartSteps {

    private HomePage homePage;

    public AddProductToCartSteps (HomePage homePage) {
        this.homePage = homePage;
    }


    @When("^he selects (.*)$")
    public void heSelectProduct(String product) {
        homePage.selectArticle(product);
    }

    @And("he fills in the quantity of the product to add via icons - and +")
    public void heFillInTheQuantityOfTheProductToAddViaIconsAnd() {
        homePage.increaseProductQuantity();
    }

    @And("he clicks on add to cart")
    public void heClicksOnAdd() {
        homePage.addToCart();
    }

    @Then("^then we observe a pop pop which indicates the following message (.*)$")
    public void thenWeObserveAPopPopWhichIndicatesTheFollowingMessageMessage(String message) {
        assertEquals(message, homePage.addedToCartMessage());
    }
}
