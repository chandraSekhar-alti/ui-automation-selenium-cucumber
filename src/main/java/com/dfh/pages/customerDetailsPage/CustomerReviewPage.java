package com.dfh.pages.customerDetailsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerReviewPage {
    WebDriver driver;

    public CustomerReviewPage(WebDriver driver){
        this.driver = driver;
    }

    private final By reviewPageTitle = By.xpath("//main/descendant::div/h2");
    private final By customerIdTitle  = By.xpath("//form/descendant::label");
    private final By customerIdInputField  = By.xpath("//form/descendant::input");
    private final By submitButton  = By.xpath("//form/descendant::button");

    public void enterCustomerId(String customerId){
        driver.findElement(reviewPageTitle).isDisplayed();
        driver.findElement(customerIdTitle).isDisplayed();
        driver.findElement(customerIdInputField).isDisplayed();
        driver.findElement(customerIdInputField).sendKeys(customerId);
    }

    public void clickOnSubmitButton(){
        driver.findElement(submitButton).isDisplayed();
        driver.findElement(submitButton).isEnabled();
        driver.findElement(submitButton).click();
    }

    public void enterCustomerDetailsAndClickOnSubmitButton(String customerId){
        enterCustomerId(customerId);
        clickOnSubmitButton();
    }
}
