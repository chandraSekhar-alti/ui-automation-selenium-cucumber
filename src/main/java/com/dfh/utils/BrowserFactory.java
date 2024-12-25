package com.dfh.utils;

import com.dfh.constants.FrameworkConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {
    public WebDriver driver;

    private static Logger log;

    public BrowserFactory() {
        log = LogManager.getLogger(BrowserFactory.class);
    }

    public WebDriver browserSetup() {
        String browserName = FrameworkConstants.BROWSER;
        log.info("This will run before the scenario ");

        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            log.error("Invalid browser type {}", browserName);
        }
        return this.driver;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
        log.info("Browser window is maximized");
    }

    public void navigateToUrl(WebDriver driver, String url) {
        driver.navigate().to(url);
        log.info("Navigated to url {}", url);
    }

    public WebDriver createDriver() {
        browserSetup();
        return this.driver;
    }

    public void quiteDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

}
