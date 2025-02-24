package com.dfh.stepdefinitions;

import com.dfh.constants.FrameworkConstants;
import com.dfh.pages.CommonPages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonPages {

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage(){
        getLoginPage().launchApplication();
    }

    @When("the user enters valid credentials")
    public void theUserEntersValidCredentials(){
        getLoginPage().signInToApplication(FrameworkConstants.USER_NAME,FrameworkConstants.PASSWORD);
    }

    @Then("the user should be successfully logged into the application")
    public void theUserShouldBeSuccessfullyLoggedIntoTheApplication() {
        getLoginPage().logoutButtonVisibility();

    }

    @And("the user should see welcome message text")
    public void theUserShouldSeeWelcomeMessageText() {
        getLoginPage().validateWelcomeMessage("Hi, practice!");
    }

    @When("the user enters {string} and {string} on the login page")
    public void theUserEntersValidAndInLoginPage(String userName, String userPassword) {
        getLoginPage().signInToApplication(userName,userPassword);
    }


    @And("the user should see {string} message text")
    public void theUserShouldSeeMessageText(String arg0) {
        getLoginPage().validateWelcomeMessage(arg0);
    }
}
