package com.dfh.hooks;

import com.dfh.constants.FrameworkConstants;
import com.dfh.driver.DriverManager;
import com.dfh.driver.TargetFactory;
import com.dfh.pages.CommonPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

import java.io.ByteArrayInputStream;
import java.time.Duration;


public class Hooks {

    private WebDriver driver;

    private static final Logger log = LogManager.getLogger(Hooks.class);

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
        CommonPages commonPages = new CommonPages();
        commonPages.getAgentLoginPage().launchApplication();
        commonPages.getAgentLoginPage().signInToApplication(FrameworkConstants.AGENT_NAME, FrameworkConstants.AGENT_PASSWORD);
        commonPages.getCustomerReviewPage().enterCustomerDetailsAndClickOnSubmitButton(FrameworkConstants.AGENT_ID);
        log.info("Login to the application successfully !");

        commonPages.getSummaryPage().launchSummaryPage();
    }

    @After
    public void tearDown(Scenario scenario) {
        log.info("Running tear down after test case");

        log.info("Starting Hooks tear down function");
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Failed screenshot", new ByteArrayInputStream(screenshot));
            log.warn("Captured screenshot size: " + screenshot.length + " bytes");
        } else {
            log.info("Scenario passed so no need for the screenshot");
        }

        //Setting driver to null after test case
        DriverManager.quit();

        log.info("Execution Ended for Scenario: {}", scenario.getName());
        log.info(" Scenario {} Execution Status : {}", scenario.getName(), scenario.getStatus());
        log.info("*****************************************************************************************");

    }


}
