package com.dfh.pages.summaryPage;

import com.dfh.Exceptions.SummaryPageException;
import com.dfh.constants.FrameworkConstants;
import com.dfh.utils.Actions;
import com.dfh.utils.Assertions;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummaryPage {
    private WebDriver driver;
    private Actions actions;
    private Assertions assertions;
    private static final Logger log = LogManager.getLogger(SummaryPage.class);

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        assertions = new Assertions(driver);
    }

    private static final By dfhLogo = By.xpath("//div[@class='logo']/img");
    public static final By summaryText = By.xpath("//div[contains(@class,'flex h-auto')]/descendant::h2");
    public static final By changeInCircumstancesText = By.xpath("//div[contains(@class,'flex')]/descendant::div[contains(@class,'scrollbar')]/h2");
    private static final By impactMonthsText = By.xpath("//div[contains(@class,'flex')]/h5[contains(text(),'impact you for more than 2 months?')]");
    private static final By impactPaymentText = By.xpath("//div[contains(@class,'flex')]/h5[contains(text(),'will impact your payment?')]");
    private static final By whatTypeOfChangeText = By.xpath("//div[contains(@class,'flex')]/h5[contains(text(),'What type of change it is?')]");
    private static final By impactYesRadioButton = By.xpath("(//button[@value='Yes'])[1]");
    private static final By impactNoRadioButton = By.xpath("(//button[@value='No'])[1]");
    private static final By paymentYesRadioButton = By.xpath("(//button[@value='Yes'])[2]");
    private static final By paymentNoRadioButton = By.xpath("(//button[@value='No'])[2]");
    private static final By selectionBox = By.xpath("//button[@role='combobox']");
    private static final By changeInIncomeSelectBoxOption = By.xpath("//span[contains(text(),'Change Income')]");
    private static final By residentialStatusSelectBoxOption = By.xpath("//span[contains(text(),'Residential Status')]");
    private static final By otherSelectBoxOption = By.xpath("//span[contains(text(),'Other')]");
    private static final By startReviewButton = By.xpath("//form/child::button");
    public static final By summaryIncomeText = By.xpath("//h4[text()='Income']");
    public static final By summaryExpenditureText = By.xpath("//h4[text()='Expenditure']");
    public static final By summaryDisposableIncomeText = By.xpath("//h4[text()='Disposable Income']");
    public static final By summaryTermLeftToPayText = By.xpath("//h4[text()='Term Left to Pay']");
    private static final By errorMessageBox = By.xpath("//div[contains(@class,'flex flex-col')]/child::div[contains(@class,'text-destructive')]");
    private static final By errorMessageBoxText = By.xpath("//div[contains(@class,'flex flex-col')]/child::div[contains(@class,'text-destructive')]/p");


    public void launchSummaryPage() {
        String summaryPageUrl = FrameworkConstants.APP_BASE_URL + "review/" + FrameworkConstants.AGENT_ID + "/summary";
        actions.launchURL(summaryPageUrl);
        actions.waitForPageLoaded(FrameworkConstants.MEDIUM_WAIT_DURATION);
        assertions.assertCurrentPageUrl(driver, summaryPageUrl);
        log.info("Navigated to summary page successfully");
    }

    public void checkTheVisibilityOfCircumstancesSection() {
        actions.isElementVisible(changeInCircumstancesText);
        actions.isElementDisplayed(changeInCircumstancesText);
    }

    public void checkTheVisibilityOfSummarySection() {
        actions.isElementVisible(summaryText);
        actions.isElementDisplayed(summaryText);
    }

    public void selectYesForImpactRadioButton() {
        actions.isElementDisplayed(impactYesRadioButton);
        actions.clickElement(impactYesRadioButton);
    }

    public void selectNoForImpactRadioButton() {
        actions.isElementDisplayed(impactNoRadioButton);
        actions.clickElement(impactNoRadioButton);
    }

    public void selectYesForPaymentRadioButton() {
        actions.isElementDisplayed(paymentYesRadioButton);
        actions.clickElement(paymentYesRadioButton);
    }

    public void selectNoForPaymentRadioButton() {
        actions.isElementDisplayed(paymentNoRadioButton);
        actions.clickElement(paymentNoRadioButton);
    }

    public void selectTypeOfChange(String typeOfChange) {
        actions.isElementDisplayed(selectionBox);
        actions.waitForElementClickable(selectionBox);
        actions.clickElement(selectionBox, FrameworkConstants.SMALL_WAIT_DURATION);

        if (typeOfChange == null || typeOfChange.trim().isEmpty()) {
            log.error("Invalid input: Type of change cannot be null or empty");
            throw new SummaryPageException("Invalid input: Type of change cannot be null or empty");
        }

        By optionLocator;
        switch (typeOfChange.trim().toLowerCase()) {
            case "change income":
                optionLocator = changeInIncomeSelectBoxOption;
                break;
            case "residential status":
                optionLocator = residentialStatusSelectBoxOption;
                break;
            case "other":
                optionLocator = otherSelectBoxOption;
                break;
            default:
                log.error("Invalid input type for type of change: {}", typeOfChange);
                throw new SummaryPageException("Invalid input type: " + typeOfChange);
        }

        try {
            actions.isElementDisplayed(optionLocator);
            actions.clickElement(optionLocator);
            log.info("Successfully selected type of change: {}", typeOfChange);
        } catch (Exception e) {
            log.error("Error while selecting type of change: {}", typeOfChange, e);
            throw new SummaryPageException("Exception while selecting type of change " + typeOfChange);
        }
    }

    public void clickOnStartReviewButton() {
        actions.isElementDisplayed(startReviewButton);
        actions.clickElement(startReviewButton);
    }

    public void checkErrorMessage(String errorMessageText) {
        actions.isElementDisplayed(errorMessageBox);
        actions.isElementDisplayed(errorMessageBoxText);
        String actualText = driver.findElement(errorMessageBoxText).getText();
        assertions.assertEquals(actualText, errorMessageText);
    }

    public void checkVisibilityOfDfhLogo(){
        actions.waitForElementPresent(dfhLogo);
        actions.isElementDisplayed(dfhLogo);
    }



}
