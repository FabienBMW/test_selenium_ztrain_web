package com.ztrain.web.config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public enum FilePropertiesReader {

    INSTANCE;

    public static FilePropertiesReader getInstance() {return INSTANCE;}

    private Properties properties = new Properties();
    public final String chromeDiverPath;
    public final String firefoxDriverPath;

    FilePropertiesReader() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("config/config.properties"));
            properties.load(reader);
            chromeDiverPath = properties.getProperty("chromeDriverPath");
            firefoxDriverPath = properties.getProperty("firefoxDriverPath");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String readProperty(String key) {
        String property = properties.getProperty(key);
        if (property == null || property.isEmpty())
            System.out.println(key + "value is missing");
        return property;
    }
}
