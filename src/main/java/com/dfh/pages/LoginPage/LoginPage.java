package com.dfh.pages.LoginPage;

import com.dfh.constants.FrameworkConstants;
import com.dfh.utils.UI;
import com.dfh.utils.Assertions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    public WebDriver driver;
    private UI UI;
    private Assertions assertions;
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        UI = new UI(driver);
        assertions = new Assertions(driver);
    }

    private static final By logoutButton = By.xpath("//div[contains(@class,'page-layout')]/descendant::a[contains(@class,'button ')]");
    private static final By loginButton = By.xpath("//button[text()='Login']");
    private static final By userNameInputBox = By.xpath("//input[@id='username']");
    private static final By passwordInputBox = By.xpath("//input[@id='password']");
    private static final By welcomeText = By.xpath("//h3[contains(@id,'username')]");


    public void enterUserName(String userEmailAddress) {
        UI.scrollToElementAtBottom(userNameInputBox);
        UI.isElementDisplayed(userNameInputBox);
        UI.setText(userNameInputBox, userEmailAddress);
    }

    public void enterPassword(String userPassword) {
        UI.isElementDisplayed(passwordInputBox);
        UI.setText(passwordInputBox, userPassword);
    }

    public void logoutButtonVisibility() {
        UI.isElementDisplayed(logoutButton);
    }

    public void clickOnLoginButton() {
        UI.scrollToElement(loginButton);
        UI.isElementDisplayed(loginButton);
        UI.clickElement(loginButton);
    }

    public void launchApplication() {
        UI.launchURL(FrameworkConstants.APP_BASE_URL+FrameworkConstants.LOGIN_PARAM);
        UI.waitForPageLoaded(FrameworkConstants.MEDIUM_WAIT_DURATION);
    }


    public void signInToApplication(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickOnLoginButton();
    }
    public void validateWelcomeMessage(String expectedText) {
        String welcomeMessageText = UI.getElementText(welcomeText);
        assertions.assertEquals(welcomeMessageText,expectedText);
    }

}
