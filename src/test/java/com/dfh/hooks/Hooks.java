package com.dfh.hooks;

import com.dfh.constants.FrameworkConstants;
import com.dfh.driver.DriverManager;
import com.dfh.driver.TargetFactory;
import com.dfh.pages.CommonPages;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ThreadGuard;

import java.time.Duration;


public class Hooks {

    private WebDriver driver;

    private static Logger log = LogManager.getLogger(Hooks.class);

    @Before(order = 1)
    public void setUp(){
        log.info("Hooks started");
        log.info("running setup() function");

        driver = ThreadGuard.protect(new TargetFactory().createInstance("chrome"));
        DriverManager.setDriver(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(FrameworkConstants.IMPLICIT_WAIT));
    }

    @Before(order = 2)
    public void launchApplication() throws InterruptedException {
        log.info("running launchApplication() function");
        CommonPages commonPages = new CommonPages();
        commonPages.getAgentLoginPage().launchApplication();
        commonPages.getAgentLoginPage().signInToApplication(FrameworkConstants.AGENT_NAME,FrameworkConstants.AGENT_PASSWORD);
        commonPages.getCustomerReviewPage().enterCustomerDetailsAndClickOnSubmitButton(FrameworkConstants.AGENT_ID);
    }

    @After
    public void tearDown(){
        log.info("Running teardown functionality");
        DriverManager.quite();
    }


}
