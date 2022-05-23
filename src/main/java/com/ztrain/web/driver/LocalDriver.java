package com.ztrain.web.driver;

import com.ztrain.web.config.FilePropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocalDriver implements Driver {

    private final WebDriver driver;

    private final String CHROME_WEBDRIVER = "webdriver.chrome.driver";
    private final String FIREFOX_WEBDRIVER = "webdriver.gecko.driver";
    public LocalDriver(String browser) {
        this.setupDriver(browser);
        switch (browser.toLowerCase()) {
            case "firefox":
                this.driver = new FirefoxDriver(getFirefoxOptions());
                break;
            default:
                this.driver = new ChromeDriver(getChromeOptions());
                break;
        }
    }

    @Override
    public WebDriver getDriver() {
        return this.driver;
    }

    @Override
    public void closeDriver() {
        this.driver.close();
    }

    private void setupDriver(String browser) {
        String prop, path;
        switch (browser.toLowerCase()) {
            case "firefox":
                prop = FIREFOX_WEBDRIVER;
                path = FilePropertiesReader.getInstance().firefoxDriverPath;
                break;
            default:
                prop = CHROME_WEBDRIVER;
                path = FilePropertiesReader.getInstance().chromeDiverPath;
                break;
        }
        System.setProperty(prop, path);
    }
}
