package com.ztrain.web.steps;

import com.ztrain.web.pageObjects.HomePage;
import com.ztrain.web.pageObjects.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ProductInformationSteps {
    public HomePage homePage;

    public ProductInformationSteps(HomePage homePage) {
        this.homePage = homePage;
    }
    @When("^User selects (.*)$")
    public void userSelectsArticle(String article) {
        homePage.selectArticle(article);
    }

    @Then("^Spawn a popup on the page with description of the (.*) and the (.*)$")
    public void spawnAPopupOnThePageWithDescriptionOfTheArticleAndThePrecise_price(String article, String price) {
        assertTrue("There is no article with this name or price",homePage.getProductPrice(price));
    }
}
