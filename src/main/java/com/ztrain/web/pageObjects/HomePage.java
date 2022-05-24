package com.ztrain.web.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

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
    @FindBy(css = "#style_quantity_wrapper__2QMug > button:nth-child(3)")
    private WebElement plusIcon;
    @FindBy(id = "style_btn_add_cart__gTXM7")
    private WebElement addToCart;
    @FindBy(id = "style_container__P9Oh0")
    public WebElement addToCartMessage;
    @FindBy(css = "#style_content_cart_wrapper__mqNbf > svg")
    private WebElement cartIcon;

    @FindBy(id = "style_btn_cart__zrT9Q")
    private WebElement orderButton;
    @FindBy(css = "#style_checkout_wrapper__JTsFz > h1")
    private WebElement orderPopUpTitle;
    @FindBy(id = "style_btn_trash_cart__ttfo9")
    private WebElement emptyCartButton;
    @FindBy(css = "#style_content_cart_wrapper__mqNbf > span")
    private WebElement cartValue;
    @FindBy(id = "card-number")
    private WebElement cardNumberField;
    @FindBy(id = "style_input_address__CrN2C")
    private WebElement addressField;
    @FindBy(id = "card-expiry")
    private WebElement expireDateField;
    @FindBy(id = "cvc")
    private WebElement cvcField;
    @FindBy(id = "style_btnSubmit__sn_sg")
    private WebElement sendPaymentFormButton;
    @FindBy(css = "#style_form_wrapper__0GdNn > p")
    private WebElement paymentValidationMessage;

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

    public void increaseProductQuantity() {
        clickOn(plusIcon);
    }

    public void addToCart() {
        clickOn(addToCart);
    }

    public String addedToCartMessage() {
        waitUntil(visibilityOf(addToCartMessage));
        return addToCartMessage.getText();
    }

    public void openCart() {
        clickOn(cartIcon);
    }

    public void order() {
        clickOn(orderButton);
    }

    public String getOrderPopUpMessage() {
        return orderPopUpTitle.getText();
    }

    public void emptyCart() {
        clickOn(emptyCartButton);
    }

    public String cartValue() {
        waitUntil(visibilityOf(addToCartMessage));
        waitUntil(invisibilityOf(addToCartMessage));
        return cartValue.getText();
    }

    public void fillPaymentForm(String cardNumber, String expirationDate, String cvc, String address) {
        sendKeysSlowly(addressField, address);
        sendKeysSlowly(cardNumberField, cardNumber);
        sendKeysSlowly(expireDateField, expirationDate);
        sendKeysSlowly(cvcField, cvc);
    }

    public void submitPaymentForm() {
        clickOn(sendPaymentFormButton);
    }

    public String paymentMessage() {
        shortUntil(visibilityOf(paymentValidationMessage));
        saveScreenShotPNG();
        return paymentValidationMessage.getText();
    }
}
