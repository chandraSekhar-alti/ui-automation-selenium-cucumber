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

    public static final String APPLICATION_URL = getRequiredProperty("appUrl");
    public static final String CUSTOMER_PAGE_DETAILS_URL = getRequiredProperty("customerDetailsPageUrl");
    public static final String HEADLESS = getRequiredProperty("headless");
    public static final String BROWSER = getRequiredProperty("browserName");
    public static final int BROWSER_HEIGHT = getRequiredIntProperty("browserHeight");
    public static final int BROWSER_WIDTH = getRequiredIntProperty("browserWidth");

    public static final String AGENT_NAME = getRequiredProperty("userName");
    public static final String AGENT_PASSWORD = getRequiredProperty("password");
    public static final String AGENT_ID = getRequiredProperty("agentId");
    public static final int IMPLICIT_WAIT = getRequiredIntProperty("waitImplicit");
    public static final int EXPLICIT_WAIT = getRequiredIntProperty("waitExplicit");
    public static final int FLUENT_WAIT = getRequiredIntProperty("waitFluent");
    public static final int SMALL_WAIT_DURATION = getRequiredIntProperty("smallWaitDuration");
    public static final int MEDIUM_WAIT_DURATION = getRequiredIntProperty("mediumWaitDuration");
    public static final int LARGE_WAIT_DURATION = getRequiredIntProperty("largeWaitDuration");
    public static final String TARGET = properties.getProperty("target");
    public static final String REMOTE_URL = properties.getProperty("remoteUrl");
    public static final String REMOTE_PORT = properties.getProperty("remotePort");


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
