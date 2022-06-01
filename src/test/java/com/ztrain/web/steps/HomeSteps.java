package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class HomeSteps {

    private HomePage homePage;

    public HomeSteps(HomePage homePage) {
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

    @Then("^he observes a pop pop which indicates the following message (.*)$")
    public void weObserveAPopPopWhichIndicatesTheFollowingMessageMessage(String message) {
        assertEquals(message, homePage.addedToCartMessage());
    }

    @When("^The user sees the prices (.*) and (.*) of a product (.*) on promotion$")
    public void theUserSeesThePricesOld_priceAndNew_priceOfAProductProductOnPromotion(String oldPrice, String newPrice, String product) {
        homePage.selectArticle(product);
        assertTrue(homePage.getOldPrice().contains(oldPrice));
        assertTrue(homePage.getNewPrice().contains(newPrice));
    }

    @Then("^The user must see the amount of (.*) in the basket equal to the price of the promotion (.*)$")
    public void theUserMustSeeTheAmountOfTheBasketEqualToThePriceOfThePromotionCart_amount(String product, String newPrice) {
        System.out.println("return " + homePage.selectProductInCart(product));
        homePage.moveToCartIcon();
        assertTrue(homePage.selectProductInCart(product).contains(newPrice));
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

    @When("^User selects (.*)$")
    public void userSelectsArticle(String article) {
        homePage.selectArticle(article);
    }

    @Then("^Spawn a popup on the page with description of the (.*) and the (.*)$")
    public void spawnAPopupOnThePageWithDescriptionOfTheArticleAndThePrecise_price(String article, String price) {
        assertTrue("There is no article with this name or price",homePage.getProductPrice(price));
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

    @Then("^A required fields error message should appear under the fields (.*) (.*)$")
    public void aRequiredFieldsErrorMessageShouldAppearUnderTheFieldsCardAddress(String card, String address) {
        System.out.println(homePage.addressErrorMessage());
        System.out.println(address);
        assertTrue(card.contains(homePage.cardErrorMessage()));
        //assertTrue(address.contains(homePage.addressErrorMessage()));
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
