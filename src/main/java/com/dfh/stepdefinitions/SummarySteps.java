package com.dfh.stepdefinitions;

import com.dfh.constants.FrameworkConstants;
import com.dfh.pages.CommonPages;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SummarySteps extends CommonPages {

    @Given("the user is on the summary page")
    public void theUserIsOnTheSummaryPage() {
        getSummaryPage().launchSummaryPage();
    }

    @Then("the user should be able to see the Circumstances and Summary sections")
    public void theUserShouldBeAbleToSeeTheAndSections() {
        getSummaryPage().checkTheVisibilityOfCircumstancesSection();
        getSummaryPage().checkTheVisibilityOfSummarySection();
    }

    @When("the user selects Yes for the duration and payment sections")
    public void theUserSelectsYesForTheDurationAndPaymentSections() {
        getSummaryPage().selectYesForImpactRadioButton();
        getSummaryPage().selectYesForPaymentRadioButton();
    }

    @And("the user selects the type of change as {string}")
    public void theUserSelectsTheTypeOfChangeAs(String typeOfChange) {
        getSummaryPage().selectTypeOfChange(typeOfChange);
    }

    @And("the user clicks on the Start Review button")
    public void theUserClicksOnTheStartReviewButton() {
        getSummaryPage().clickOnStartReviewButton();
    }

    @Then("the user should be navigated to the household page")
    public void theUserShouldBeNavigatedToThePage() {
        getHouseHoldPage().validateHouseholdPageUrl();
    }

    @And("within the Household page, the user should be able to see the configured users")
    public void withinTheHouseholdPageTheUserShouldBeAbleToSeeTheConfiguredUsers() {
    }
}
