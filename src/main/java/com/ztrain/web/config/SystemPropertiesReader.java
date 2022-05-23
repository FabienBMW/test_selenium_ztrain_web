package com.ztrain.web.config;

import java.util.Locale;

public enum SystemPropertiesReader {

    INSTANCE;

    public static SystemPropertiesReader getInstance() {return INSTANCE;}

    public String browser;
    public boolean headless;
    public EnvPropertiesReader env;

    SystemPropertiesReader() {
        browser = System.getProperty("browser", "chrome");
        headless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        env = EnvPropertiesReader.valueOf(System.getProperty("env","production").toUpperCase());
    }
}
