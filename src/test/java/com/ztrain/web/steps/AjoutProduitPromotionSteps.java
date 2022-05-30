package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertTrue;

public class AjoutProduitPromotionSteps {

    private HomePage homePage;

    public AjoutProduitPromotionSteps(HomePage homePage) {
        this.homePage = homePage;
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
}
