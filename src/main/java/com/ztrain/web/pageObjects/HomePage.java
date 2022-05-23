package com.ztrain.web.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class HomePage extends Page {

    @FindBy(css = "nav h1")
    private WebElement ztrainLogo;

    @FindBy(id = "style_avatar_wrapper__pEGIQ")
    private WebElement accountIcon;
    @FindBy(css = "#style_showDropdown__PBBOV > a:nth-child(2)")
    private WebElement logoutButton;
    @FindBy(className = "style_card__gNEqX")
    private List<WebElement> products;
    @FindBy(id = "style_price__QNXBx")
    private WebElement productPrice;

    public String getTitle() {
        return this.driver.getTitle();
    }

    public boolean isZtrainLogoDisplayed() {
        super.wait.until(ExpectedConditions.urlContains("home"));
        super.wait.until(visibilityOf(this.ztrainLogo));
        return this.ztrainLogo.isDisplayed();
    }

    public void moveToAccountIcon() {
        moveToElement(accountIcon);
        System.out.println(accountIcon.getText());
    }

    public void logOut() {
        waitUntil(visibilityOf(logoutButton));
        //System.out.println(logoutButton.getText());
        logoutButton.click();
    }

    public void selectArticle(String article) {
        longUntil(ExpectedConditions.urlContains("home"));
        waitForLoadingPage();
        longUntil(ExpectedConditions.visibilityOfAllElements());
        for (WebElement element: products) {
            if (element.getText().contains(article)){
                clickOn(element);
                break;
            }
        }
    }

    public boolean getProductPrice(String price) {
        return productPrice.getText().contains(price);
    }
}
