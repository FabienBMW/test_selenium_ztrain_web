package com.ztrain.web.driver;

public class DriverFactory {

    public static Driver getDriver(String browser) {
        return new LocalDriver(browser);
    }
}
