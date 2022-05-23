package com.ztrain.web.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public enum EnvPropertiesReader {

    PRODUCTION,
    INTEGRATION;

    private final static String CONFIG_ENV = "config/env.properties";
    private String envUrl;

    public void initEnv() {
        Properties prop = new Properties();
        try {
            prop.load(new FileReader(CONFIG_ENV));
            prop.forEach((key, value) -> {
                EnvPropertiesReader.valueOf(key.toString().toUpperCase()).setUrl(value.toString());
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setUrl(String url) {
        this.envUrl = url;
    }

    public String getEnvUrl() {
        if (this.envUrl == null)
            this.initEnv();
        return envUrl;
    }

    public String getEnvUrl(String endpoint) {
        String base = getEnvUrl();
        if (!base.endsWith("/") && !endpoint.startsWith("/"))
            return base + "/" + endpoint;
        else
            return base + endpoint;
    }
}
