package com.dfh.hooks;

import com.dfh.constants.FrameworkConstants;
import com.dfh.driver.DriverManager;
import com.dfh.driver.TargetFactory;
import com.dfh.pages.CommonPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

import java.time.Duration;


public class Hooks {

    private WebDriver driver;

    private static Logger log = LogManager.getLogger(Hooks.class);

    @Before(order = 1)
    public void setUp(Scenario scenario) {
        log.info("*****************************************************************************************");
        log.info("Execution Started for Scenario: {}", scenario.getName());

        driver = ThreadGuard.protect(new TargetFactory().createInstance(FrameworkConstants.BROWSER));
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.IMPLICIT_WAIT));
        System.setProperty("allure.results.directory", "target/allure-results");

    }

    @Before(order = 2)
    public void launchApplication() throws InterruptedException {
        log.info("running launchApplication() function");
        CommonPages commonPages = new CommonPages();
        commonPages.getAgentLoginPage().launchApplication();
        commonPages.getAgentLoginPage().signInToApplication(FrameworkConstants.AGENT_NAME, FrameworkConstants.AGENT_PASSWORD);
        commonPages.getCustomerReviewPage().enterCustomerDetailsAndClickOnSubmitButton(FrameworkConstants.AGENT_ID);
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("Running tear down functionality");
        if (DriverManager.getDriver() != null) {
            DriverManager.quit();
        } else {
            log.warn("No WebDriver instance to quit");
        }

        log.info("Execution Ended for Scenario: {}", scenario.getName());
        log.info(" Scenario {} Execution Status : {}", scenario.getName(), scenario.getStatus());
        log.info("*****************************************************************************************");

    }


}
