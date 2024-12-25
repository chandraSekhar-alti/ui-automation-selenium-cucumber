package com.dfh.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PropertyLoader {
    private static Logger log;

    static {
        log = LogManager.getLogger(PropertyLoader.class);
    }


    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();


        try (InputStream inputStream = PropertyLoader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                log.error("Unable to find properties file {}", fileName);
                throw new RuntimeException("Unable to find properties file " + fileName);
            }
            properties.load(inputStream);
            log.info("Properties file loaded successfully");
        } catch (IOException e) {
            log.info("Failed to load properties from file {}", fileName);
            throw new RuntimeException("Failed to load properties from file " + fileName);
        }
        return properties;
    }
}
