package com.dfh.pages.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerLoginPage {

    public WebDriver driver;
    public CustomerLoginPage(WebDriver driver){
        this.driver = driver;
    }

    private static final By customerIdInputField = By.xpath("//input[@name='clientId']");
    private static final By customerSubmitButton = By.xpath("//button[@type='submit']");


    public void enterCustomerId(String customerId){
        driver.findElement(customerIdInputField).isDisplayed();
        driver.findElement(customerIdInputField).sendKeys(customerId);
    }

    public void clickOnSubmitButton(){
        driver.findElement(customerSubmitButton).isDisplayed();
        driver.findElement(customerSubmitButton).click();
    }

}
