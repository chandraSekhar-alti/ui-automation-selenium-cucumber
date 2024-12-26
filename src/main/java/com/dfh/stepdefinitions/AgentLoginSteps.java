package com.dfh.stepdefinitions;

import com.dfh.pages.CommonPages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AgentLoginSteps extends CommonPages {


    @Given("^the user on the login page$")
    public void theUSerOnTheLoginPage() {
        System.out.println("theUSerOnTheLoginPage");
//        agentLoginPage.clickOnAgentTab();
    }


    @When("the user enter valid credentials")
    public void theUserEnterValidCredentials() {
//        agentLoginPage.enterUserDetails(FrameworkConstants.AGENT_NAME, FrameworkConstants.AGENT_PASSWORD);
    }

    @And("click on login button")
    public void clickOnLoginButton() {
//        agentLoginPage.clickOnLoginButton();
    }


    @Then("user should be redirect to customer details page")
    public void userShouldBeRedirectToCustomerDetailsPage() {
//        String expectedUrl =FrameworkConstants.CUSTOMER_PAGE_DETAILS_URL;
//
//        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(d -> UI.validateCurrentPageUrl(driver,expectedUrl));
//        UI.validateCurrentPageUrl(driver,expectedUrl);
    }

    @When("user enter valid customer id and click on submit button")
    public void userEnterValidCustomerIdAndClickOnSubmitButton() {
//        customerPage.enterCustomerId("433332");
//        customerPage.clickOnSubmitButton();

    }

    @Then("user should should be navigate to homepage")
    public void userShouldShouldBeNavigateToHomepage() {
    }
}
