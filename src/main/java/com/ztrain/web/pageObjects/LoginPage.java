package com.ztrain.web.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {
    @FindBy(id = "email_login")
    private WebElement userNameInput;
    @FindBy(id = "password_login")
    public WebElement passwordInput;
    @FindBy(id = "btn_login")
    private WebElement submitButton;
    @FindBy(css = "#style_container_input_password___0rEz > div > svg")
    private WebElement eyeButton;

    @FindBy(css = "#style_content_form__yXJox > p:nth-child(2)")
    private WebElement emailErrorMessage;
    @FindBy(css = "#style_content_form__yXJox > p:nth-child(5)")
    private WebElement passwordErrorMessage;

    public void goToLoginPage() {
        driver.get(ENV.getEnvUrl("/auth/login"));
    }

    public void fillLoginForm(String userName, String password) {
        sendKeysSlowly(userNameInput, userName);
        sendKeysSlowly(passwordInput, password);
    }

    public void fillEmailField(String email) {
        sendKeysSlowly(userNameInput, email);
    }

    public void clickOnEyeButton() {
        clickOn(eyeButton);
    }

    public void clickOnConnexionButton() {
        clickOn(this.submitButton);
    }

    public String emailErrorMessage() {
        return getText(emailErrorMessage);
    }

    public String passwordErrorMessage() {
        return getText(passwordErrorMessage);
    }
}
