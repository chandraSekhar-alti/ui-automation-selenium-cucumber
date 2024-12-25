package com.dfh.utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UI {

    public static boolean validateCurrentPageUrl(WebDriver driver, String expectedUrl) {
        if (driver == null || expectedUrl == null || expectedUrl.isEmpty()) {
            throw new IllegalArgumentException("Driver or expected URL cannot be null/empty");
        }
        boolean valuetoReturn = false;

        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotNull(currentUrl,"Current Url is null ");
        if (currentUrl.equalsIgnoreCase(expectedUrl)){
            Assert.assertEquals(currentUrl,expectedUrl,"Current Url does not matches with the expected Url");
            valuetoReturn = true;
        }else {
            valuetoReturn = false;
        }
        return valuetoReturn;
    }
}
