package com.ztrain.web.pageObjects;

import com.ztrain.web.config.EnvPropertiesReader;
import com.ztrain.web.config.SystemPropertiesReader;
import com.ztrain.web.driver.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Page {

    private final static Logger LOG = LogManager.getLogger(Page.class);
    public static final EnvPropertiesReader ENV = SystemPropertiesReader.getInstance().env;
    public final WebDriver driver;
    protected JavascriptExecutor js;
    protected Actions actions;
    protected WebDriverWait wait;
    protected WebDriverWait loadingWait;
    protected WebDriverWait shortWait;
    protected WebDriverWait longWait;

    public Page() {
        this.driver = WebDriverManager.getDriver();
        PageFactory.initElements(this.driver, this);
        this.shortWait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(20));
        this.loadingWait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
        this.js = (JavascriptExecutor) driver;
        this.actions = new Actions(driver);
    }

    /**
     * Wait until the condition in the function is satisfied
     *
     * @param isTrue the condition
     * @param <V>    the condition return type
     * @return true is the condition is satisfied, false if the condition hasn't been satisfied in the given time
     */
    protected <V>boolean waitUntil(Function<? super WebDriver, V> isTrue){
        try{
            wait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    protected <V>boolean shortUntil(Function<? super WebDriver, V> isTrue){
        try{
            shortWait.until(isTrue);
            //LOG.info("Log message in shortwait ok");
            return false;
        }catch (Exception e){
            return true;
        }
    }


    protected <V>boolean longUntil(Function<? super WebDriver, V> isTrue){
        try{
            wait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Wait until the page is loaded
     */
    protected void waitForLoadingPage(){
        if(!longUntil(driver->js.executeScript("return document.readyState").equals("complete") || js.executeScript("return document.readyState").equals("interactive") )){
            System.out.println(driver.getCurrentUrl() + " not loaded");
            return;
        }
        System.out.println(driver.getCurrentUrl() + " successfully loaded");
    }

    /**
     * Open the page with the given url
     * @param url
     */
    protected void get(String url){
        driver.get(url);
        waitForLoadingPage();
    }

    protected void clickOn(WebElement element){
        if(longUntil(visibilityOf(element))){
            System.out.println("Element not visible after click");
        }

        if(shortUntil(elementToBeClickable(element))){
            System.out.println("Element not clickable");
        }
        element.click();
    }

    public void moveToElement(WebElement element) {
        if(longUntil(visibilityOf(element))){
            System.out.println("Element not visible after click");
        }
        actions.moveToElement(element).perform();
    }

    @Attachment(value = "screenshot", type = "image/png")
    public void saveScreenShotPNG(){
        Allure.addAttachment("screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    protected void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true); scrollBy(0, -window.innerHeight/2 + arguments[0].offsetHeight/2);", element);
    }

    protected void scrollUpToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true); scrollBy(0, -window.innerHeight/2 - arguments[0].offsetHeight/2);", element);
    }

    protected void scrollDownToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);arguments[0].scrollTop=arguments[0].scrollHeight", element);
    }


    public void sendKeysSlowly(WebElement webElement, String key) {
        for (int i = 0; i < key.length(); i++) {
            webElement.sendKeys(key.substring(i, i + 1));
        }
    }

}
