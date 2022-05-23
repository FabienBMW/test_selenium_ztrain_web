package com.ztrain.web.steps;

import com.ztrain.web.driver.WebDriverManager;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    WebDriver driver = WebDriverManager.getDriver();

    public Hooks() {
    }

    @Before
    public void beforeTests() {

    }
}
