package com.ztrain.web.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

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
    @FindBy(className = "style_card_body__EhpLW")
    private List<WebElement> cartProducts;
    @FindBy(id = "style_price__QNXBx")
    private WebElement productPrice;

    @FindBy(id = "style_initial_price__Z4QbL")
    private WebElement oldPrice;
    @FindBy(css = "#style_price__QNXBx > span")
    private WebElement newPrice;
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

    @FindBy(css = "#style_form_wrapper__0GdNn > p:nth-child(4)")
    private WebElement addressErrorMessage;
    @FindBy(css = "#style_form_wrapper__0GdNn > p:nth-child(2)")
    private WebElement cardErrorMessage;

    public String getTitle() {
        return this.driver.getTitle();
    }

    public boolean isZtrainLogoDisplayed() {
        if (waitUntil(ExpectedConditions.urlContains("home")) && waitUntil(visibilityOf(this.ztrainLogo)))
            return this.ztrainLogo.isDisplayed();
        return false;
    }

    public void moveToAccountIcon() {
        moveToElement(accountIcon);
    }

    public void moveToCartIcon() {
        moveToElement(cartIcon);
    }

    public void logOut() {
        if (waitUntil(visibilityOf(logoutButton)))
            logoutButton.click();
    }

    public void selectArticle(String article) {
        if (longUntil(ExpectedConditions.urlContains("home"))) {
            waitForLoadingPage();
            if (longUntil(ExpectedConditions.visibilityOfAllElements(products))) {
                clickOn(products.stream()
                        .filter(product -> product.getText().contains(article))
                        .collect(Collectors.toList())
                        .get(0)
                );
            }
        }
    }

    public String selectProductInCart(String product) {
        if (waitUntil(visibilityOfAllElements(cartProducts))) {
            return cartProducts.stream()
                    .filter(webElement -> product.contains(webElement.getText().substring(0,15)))
                    .collect(Collectors.toList())
                    .get(0).getText();
        }
        return "The product was not founded";
    }

    public boolean getProductPrice(String price) {

        return getText(productPrice).contains(price);
    }

    public String getNewPrice() {
        return getText(newPrice);
    }

    public String getOldPrice() {
        return getText(oldPrice);
    }

    public void increaseProductQuantity() {
        clickOn(plusIcon);
    }

    public void addToCart() {
        clickOn(addToCart);
    }

    public String addedToCartMessage() {
        return getText(addToCartMessage);
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
        if (waitUntil(visibilityOf(addToCartMessage))) {
            if (waitUntil(textToBePresentInElement(cartValue, "0"))) {
                return "0";
            }
        }
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
        if (shortUntil(visibilityOf(paymentValidationMessage))) {
            saveScreenShotPNG();
            return paymentValidationMessage.getText();
        }
        return "Payment validation message not visible";
    }

    public String addressErrorMessage() {
        if (waitUntil(visibilityOf(addressErrorMessage)))
            return addressErrorMessage.getText();
        return "No address error message";
    }

    public String cardErrorMessage() {
        if (waitUntil(visibilityOf(cardErrorMessage)))
            return cardErrorMessage.getText();
        return "No card error message";
    }
}
