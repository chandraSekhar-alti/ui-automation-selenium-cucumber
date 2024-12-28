package com.dfh.pages.LoginPage;

import com.dfh.constants.FrameworkConstants;
import com.dfh.utils.Actions;
import com.dfh.utils.Assertions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgentLoginPage {

    public WebDriver driver;
    private Actions actions;
    private Assertions assertions;
    private static final Logger log = LogManager.getLogger(AgentLoginPage.class);

    public AgentLoginPage(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        assertions = new Assertions();
    }

    private static final By agentEmailAddress = By.xpath("//input[@name='username']");
    private static final By agentPassword = By.xpath("//input[@type='password']");
    private static final By agentLoginButton = By.xpath("//button[@type='submit' and text()='Login']");
    private static final By agentButton = By.xpath("//button[@type='button' and text()='Agent']");


    public void enterUserName(String userEmailAddress) {
        actions.isElementDisplayed(agentEmailAddress);
        actions.setText(agentEmailAddress, userEmailAddress);
    }

    public void enterPassword(String userPassword) {
        actions.isElementDisplayed(agentPassword);
        actions.setText(agentPassword, userPassword);
    }

    public void enterUserDetails(String userEmailAddress, String userPassword) {

    }

    public void clickOnLoginButton() {
        actions.isElementDisplayed(agentLoginButton);
        actions.clickElement(agentLoginButton);
    }

    public void clickOnAgentTab() {
        actions.isElementDisplayed(agentButton);
        actions.clickElement(agentButton);
    }

    public void launchApplication() {
        actions.launchURL(FrameworkConstants.APPLICATION_URL);
        actions.waitForPageLoaded(FrameworkConstants.MEDIUM_WAIT_DURATION);
    }


    public void signInToApplication(String userName, String password) {
        clickOnAgentTab();
        enterUserName(userName);
        enterPassword(password);
        clickOnLoginButton();
    }

    public void signOutFromApplication() {
        //have to implement the sign out functionality here
    }

    public void enterCustomerId() {

    }


}
