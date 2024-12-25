package com.dfh.pages.LoginPage;

import com.dfh.constants.FrameworkConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AgentLoginPage {

    public WebDriver driver;
    public AgentLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private static final By agentEmailAddress = By.xpath("//input[@name='username']");
    private static final By agentPassword = By.xpath("//input[@type='password']");
    private static final By agentLoginButton = By.xpath("//button[@type='submit' and text()='Login']");
    private static final By agentButton = By.xpath("//button[@type='button' and text()='Agent']");


    public void enterUserName(String userEmailAddress){
        driver.findElement(agentEmailAddress).isDisplayed();
        driver.findElement(agentEmailAddress).sendKeys(userEmailAddress);
    }

    public void enterPassword(String userPassword){
        driver.findElement(agentPassword).isDisplayed();
        driver.findElement(agentPassword).sendKeys(userPassword);
    }

    public void enterUserDetails(String userEmailAddress, String userPassword){

    }

    public void clickOnLoginButton(){
        driver.findElement(agentLoginButton).isDisplayed();
        driver.findElement(agentLoginButton).click();
    }

    public void clickOnAgentTab(){
        driver.findElement(agentButton).isDisplayed();
        driver.findElement(agentButton).click();
    }

    public void launchApplication() throws InterruptedException {
        driver.navigate().to(FrameworkConstants.APPLICATION_URL);
        Thread.sleep(5000);
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
