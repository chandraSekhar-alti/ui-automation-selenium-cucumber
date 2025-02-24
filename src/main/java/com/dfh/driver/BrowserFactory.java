package com.dfh.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.dfh.constants.FrameworkConstants;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.HashMap;
import java.util.Map;

public enum BrowserFactory {

    CHROME {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver(getOptions());
        }

        @Override
        public ChromeOptions getOptions() {
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> preferences = new HashMap<String, Object>();

            // Disable browser notification (2 = blocked)
//            preferences.put("profile.default_content_setting_values.notifications", 2);

//            // Disable the prompts to save Credentials/ Passwords
//            preferences.put("credentials_enable_service", false);

            // Disables Chromes built in password manager
//            preferences.put("profile.password_manager_enabled", false);
//
            // Disable auto fill of form data
//            preferences.put("autofill.profile_enabled", false);

            // Apply preferences map to the ChromeOptions Object
//            options.setExperimentalOption("preferences", preferences);

            // Disable browser extensions
//            options.addArguments("--disable-extensions");

            // Remove the info bar that says "Chrome is being controlled by automated software"
//            options.addArguments("--disable-infobars");

            // Disable notifications (as an additional layer, if not covered by prefs)
//            options.addArguments("--disable-notifications");

            // Allow cross-origin requests from all origins (useful for testing cross-domain resources)
//            options.addArguments("--remote-allow-origins=*");

//            options.setAcceptInsecureCerts(true);

            if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
                options.addArguments("--headless=new");
                options.addArguments("window-size=1800,900");
            }

            return options;
        }

    }, FIREFOX {
        @Override
        public WebDriver createDriver() {
            return new FirefoxDriver(getOptions());
        }

        @Override
        public FirefoxOptions getOptions() {
            FirefoxOptions options = new FirefoxOptions();

            options.setAcceptInsecureCerts(true);

            if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
                options.addArguments("--headless=new");
                options.addArguments("window-size=1800,900");
            }

            return options;
        }
    }, EDGE {
        @Override
        public WebDriver createDriver() {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver(getOptions());
        }

        @Override
        public EdgeOptions getOptions() {

            EdgeOptions options = new EdgeOptions();
            Map<String, Object> preferences = new HashMap<String, Object>();
//            preferences.put("profile.default_content_setting_values.notifications", 2);
//            preferences.put("credentials_enable_service", false);
//            preferences.put("profile.password_manager_enabled", false);
//            preferences.put("autofill.profile_enabled", false);
//            options.setExperimentalOption("preferences", preferences);
//
//            options.addArguments("--disable-extensions");
//            options.addArguments("--disable-infobars");
//            options.addArguments("--disable-notifications");
//            options.addArguments("--remote-allow-origins=*");

            options.setAcceptInsecureCerts(true);

            if (Boolean.valueOf(FrameworkConstants.HEADLESS) == true) {
                options.addArguments("--headless=new");
                options.addArguments("window-size=1800,900");
            }

            return options;
        }
    }, SAFARI {
        @Override
        public WebDriver createDriver() {
            return new SafariDriver(getOptions());
        }

        @Override
        public SafariOptions getOptions() {
            SafariOptions options = new SafariOptions();
            options.setAutomaticInspection(false);

//            if (TRUE.equals(Boolean.valueOf(FrameworkConstants.HEADLESS)))
//                throw new HeadlessNotSupportedException(options.getBrowserName());

            return options;
        }
    };


    public abstract WebDriver createDriver();

    public abstract MutableCapabilities getOptions();
}
