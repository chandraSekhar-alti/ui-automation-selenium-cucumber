package com.dfh.pages.LoginPage;

import com.dfh.constants.FrameworkConstants;
import com.dfh.utils.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgentLoginPage {

    public WebDriver driver;
    private Actions actions;


    public AgentLoginPage(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
    }

    private static final By agentEmailAddress = By.xpath("//input[@name='username']");
    private static final By agentPassword = By.xpath("//input[@type='password']");
    private static final By agentLoginButton = By.xpath("//button[@type='submit' and text()='Login']");
    private static final By agentButton = By.xpath("//button[@type='button' and text()='Agent']");


    public void enterUserName(String userEmailAddress){
        actions.isElementVisible(agentEmailAddress);
        actions.setText(agentEmailAddress,userEmailAddress );
    }

    public void enterPassword(String userPassword){
        actions.isElementVisible(agentPassword);
        actions.setText(agentPassword,userPassword);
    }

    public void enterUserDetails(String userEmailAddress, String userPassword){

    }

    public void clickOnLoginButton(){
        actions.isElementVisible(agentLoginButton);
        actions.clickElement(agentLoginButton);
    }

    public void clickOnAgentTab(){
        actions.isElementVisible(agentButton);
        actions.clickElement(agentButton);
    }

    public void launchApplication() throws InterruptedException {
        actions.launchURL(FrameworkConstants.APPLICATION_URL);
        actions.waitForPageLoaded(FrameworkConstants.MEDIUM_WAIT_DURATION);
    }

    public void signInToApplication(String userName, String password){
        clickOnAgentTab();
        enterUserName(userName);
        enterPassword(password);
        clickOnLoginButton();
    }

    public void signOutFromApplication(){
        //have to implement the sign out functionality here
    }

    public void enterCustomerId(){

    }


}
