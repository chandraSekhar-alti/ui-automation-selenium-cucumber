package com.dfh.stepdefinitions;

import com.dfh.pages.CommonPages;

import com.dfh.pages.summaryPage.SummaryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;



public class SummarySteps extends CommonPages {
    private static final Logger log = LogManager.getLogger(SummarySteps.class);

    @Given("the user is on the summary page")
    public void theUserIsOnTheSummaryPage() {
        getSummaryPage().launchSummaryPage();
    }

    @Then("the user should be able to see the Circumstances and Summary sections")
    public void theUserShouldBeAbleToSeeTheAndSections() {
        getSummaryPage().checkTheVisibilityOfCircumstancesSection();
        getSummaryPage().checkTheVisibilityOfSummarySection();
    }

    @When("the user selects Yes for both the duration and payment sections")
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
        getHouseHoldPage().checkVisibilityOfHouseholdText();
    }

    @When("the user does not select any options for both the duration and payment sections")
    public void theUserDoesNotSelectAnyOptionsForBothTheDurationAndPaymentSections() {
        log.info("User does not select any options in summary form");
    }

    @Then("the user should see an error message indicating that {string}")
    public void theUserShouldSeeAnErrorMessageIndicatingThat(String errorMessage) {
        getSummaryPage().checkErrorMessage(errorMessage);
    }

    @Then("the following components should be visible:")
    public void theFollowingComponentsShouldBeVisible(List<String> componentsTexts) {
        System.out.println(componentsTexts);
        getAssertions().assertText(SummaryPage.changeInCircumstancesText, componentsTexts.get(0));
        getAssertions().assertText(SummaryPage.summaryText, componentsTexts.get(1));
        getAssertions().assertText(SummaryPage.summaryIncomeText, componentsTexts.get(2));
        getAssertions().assertText(SummaryPage.summaryExpenditureText, componentsTexts.get(3));
        getAssertions().assertText(SummaryPage.summaryDisposableIncomeText, componentsTexts.get(4));
        getAssertions().assertText(SummaryPage.summaryTermLeftToPayText, componentsTexts.get(5));
    }
}
