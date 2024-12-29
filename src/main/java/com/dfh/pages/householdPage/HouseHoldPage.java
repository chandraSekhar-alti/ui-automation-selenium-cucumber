package com.dfh.pages.householdPage;

import com.dfh.constants.FrameworkConstants;
import com.dfh.utils.Actions;
import com.dfh.utils.Assertions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HouseHoldPage {

    private WebDriver driver;
    private Actions actions;
    private Assertions assertions;
    private static final Logger log = LogManager.getLogger(HouseHoldPage.class);
    private static final String householdPageUrl = FrameworkConstants.APP_BASE_URL + "review/" + FrameworkConstants.AGENT_ID + "/household";


    public HouseHoldPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        assertions = new Assertions(driver);
    }

    // implement locators in this section
    private final static By householdText = By.xpath("//h2[contains(@class, 'text-2xl') and contains(@class, 'sm:text-left')]");
//    private final static By householdText= By.xpath("//h2[contains(@class, 'text-2xl') and contains(@class, 'sm:text-left')]");
//    private final static By householdText= By.xpath("//h2[contains(@class, 'text-2xl') and contains(@class, 'sm:text-left')]");
//    private final static By householdText= By.xpath("//h2[contains(@class, 'text-2xl') and contains(@class, 'sm:text-left')]");


    public void launchHouseholdPage() {
        actions.launchURL(householdPageUrl);
        actions.waitForPageLoaded(FrameworkConstants.MEDIUM_WAIT_DURATION);
        validateHouseholdPageUrl();
        log.info("Navigated to household page successfully");
    }

    public void validateHouseholdPageUrl() {
        assertions.assertCurrentPageUrl(driver, householdPageUrl);
    }

    public void checkVisibilityOfHouseholdText() {
        actions.isElementDisplayed(householdText);
    }
}
