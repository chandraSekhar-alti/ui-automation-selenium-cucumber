package com.dfh.constants;

import com.dfh.utils.PropertyLoader;

import java.util.Properties;

public final class FrameworkConstants {
    private static final Properties properties;

    static {
        properties = PropertyLoader.loadProperties("configurations.properties");
        if (properties == null) {
            throw new IllegalStateException("Failed to load configurations.properties");
        }
    }

    private FrameworkConstants() {
        // Prevent instantiation
    }

//    public static final String APPLICATION_URL = getRequiredProperty("APP_URL");
    public static final String APP_BASE_URL = getRequiredProperty("APP_BASE_URL");
    public static final String LOGIN_PARAM = getRequiredProperty("LOGIN_URL");
    public static final String HEADLESS = getRequiredProperty("HEADLESS");
    public static final String BROWSER = getRequiredProperty("BROWSER_NAME");
    public static final int BROWSER_HEIGHT = getRequiredIntProperty("BROWSER_HEIGHT");
    public static final int BROWSER_WIDTH = getRequiredIntProperty("BROWSER_WIDTH");

    public static final String USER_NAME = getRequiredProperty("USER_NAME");
    public static final String PASSWORD = getRequiredProperty("USER_PASSWORD");
    public static final String AGENT_ID = getRequiredProperty("AGENT_ID");
    public static final int IMPLICIT_WAIT = getRequiredIntProperty("WAIT_IMPLICIT");
    public static final int EXPLICIT_WAIT = getRequiredIntProperty("WAIT_EXPLICIT");
    public static final int FLUENT_WAIT = getRequiredIntProperty("WAIT_FLUENT");
    public static final int SMALL_WAIT_DURATION = getRequiredIntProperty("SMALL_WAIT_DURATION");
    public static final int MEDIUM_WAIT_DURATION = getRequiredIntProperty("MEDIUM_WAIT_DURATION");
    public static final int LARGE_WAIT_DURATION = getRequiredIntProperty("LARGE_WAIT_DURATION");
    public static final String TARGET = properties.getProperty("TARGET");
    public static final String REMOTE_URL = properties.getProperty("REMOTE_URL");
    public static final String REMOTE_PORT = properties.getProperty("REMOTE_PORT");


    private static String getRequiredProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalStateException("Required property '" + key + "' is missing in configurations.properties");
        }
        return value;
    }

    private static int getRequiredIntProperty(String key) {
        String value = getRequiredProperty(key);
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Property '" + key + "' must be a valid integer, but found: " + value);
        }
    }
}
