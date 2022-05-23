package com.ztrain.web.pageObjects;

import com.ztrain.web.config.EnvPropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class LoginPage extends Page {
    @FindBy(id = "email_login")
    private WebElement userNameInput;
    @FindBy(id = "password_login")
    public WebElement passwordInput;
    @FindBy(id = "btn_login")
    private WebElement submitButton;
    @FindBy(css = "#style_container_input_password___0rEz > div > svg")
    private WebElement eyeButton;

    @FindBy(css = "#style_content_form__yXJox > p")
    private WebElement emailErrorMessage;

    public void goToLoginPage() {
        driver.get(ENV.getEnvUrl("/auth/login"));
    }

    public void fillLoginForm(String userName, String password) {
        sendKeysSlowly(userNameInput, userName);
        sendKeysSlowly(passwordInput, password);
    }

    public void clickOnEyeButton() {
        clickOn(eyeButton);
    }

    public void clickOnConnexionButton() {
        clickOn(this.submitButton);
    }

    public boolean checkLoginErrorMessage() {
        return waitUntil(visibilityOf(emailErrorMessage));
    }
}
