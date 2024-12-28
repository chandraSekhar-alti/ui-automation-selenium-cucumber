package com.dfh.pages.customerDetailsPage;

import com.dfh.utils.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerReviewPage {
    WebDriver driver;
    private Actions actions;

    public CustomerReviewPage(WebDriver driver){
        this.driver = driver;
        actions =  new Actions(driver);
    }

    private final By reviewPageTitle = By.xpath("//main/descendant::div/h2");
    private final By customerIdTitle  = By.xpath("//form/descendant::label");
    private final By customerIdInputField  = By.xpath("//form/descendant::input");
    private final By submitButton  = By.xpath("//form/descendant::button");

    public void enterCustomerId(String customerId){
        actions.isElementDisplayed(reviewPageTitle);
        actions.isElementDisplayed(customerIdTitle);
        actions.isElementDisplayed(customerIdInputField);
        actions.setText(customerIdInputField, customerId);
    }

    public void clickOnSubmitButton(){
        actions.isElementDisplayed(submitButton);
        actions.waitForElementClickable(submitButton);
        actions.clickElement(submitButton);
    }

    public void enterCustomerDetailsAndClickOnSubmitButton(String customerId){
        enterCustomerId(customerId);
        clickOnSubmitButton();
    }
}
