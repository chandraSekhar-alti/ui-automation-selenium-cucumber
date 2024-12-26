package com.dfh.pages.LoginPage;

import com.dfh.utils.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage {

    public WebDriver driver;
    private Actions actions;

    public CustomerLoginPage(WebDriver driver){
        this.driver = driver;
        actions = new Actions(driver);
    }

    private static final By customerIdInputField = By.xpath("//input[@name='clientId']");
    private static final By customerSubmitButton = By.xpath("//button[@type='submit']");


    public void enterCustomerId(String customerId){
        actions.isElementVisible(customerIdInputField);
        actions.setText(customerIdInputField, customerId);
    }

    public void clickOnSubmitButton(){
        actions.isElementVisible(customerSubmitButton);
        actions.clickElement(customerSubmitButton);
    }

}
