package com.ztrain.web;

import com.ztrain.web.config.SystemPropertiesReader;
import com.ztrain.web.driver.WebDriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.ztrain.web.steps", "com/ztrain/web/pageObjects"},
        plugin = {
                "pretty",
                "html:target/reports/html/htmlreport",
                "json:target/reports/jsonreports/index.json",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    private static final SystemPropertiesReader SYSTEM_PROPERTIES = SystemPropertiesReader.getInstance();
    private static WebDriver driver;

    @BeforeClass
    public static void beforeTest() {
        WebDriverManager.setDriver(SYSTEM_PROPERTIES.browser);
        driver = WebDriverManager.getDriver();
    }

    @AfterClass
    public static void afterTest() {
        driver.quit();
    }
}
