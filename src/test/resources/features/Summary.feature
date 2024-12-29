Feature: Summary Page Functionality Validation

  @Regression
  Scenario: Validate the Summary page functionality by selecting change income option
    Given the user is on the summary page
    Then the user should be able to see the Circumstances and Summary sections
    When the user selects Yes for both the duration and payment sections
    And the user selects the type of change as "change income"
    And the user clicks on the Start Review button
    Then the user should be navigated to the household page
    And within the Household page, the user should be able to see the configured users

  @Regression
  Scenario: Validate navigating from the summary page to the household page by selecting Residential status option
    Given the user is on the summary page
    When the user selects Yes for both the duration and payment sections
    And the user selects the type of change as "Residential Status"
    And the user clicks on the Start Review button
    Then the user should be navigated to the household page
    And within the Household page, the user should be able to see the configured users

  @Regression
  Scenario: Validate navigating from the summary page to the household page by selecting other option
    Given the user is on the summary page
    When the user selects Yes for both the duration and payment sections
    And the user selects the type of change as "Other"
    And the user clicks on the Start Review button
    Then the user should be navigated to the household page
    And within the Household page, the user should be able to see the configured users

  @Regression
  Scenario: Validate error handling when no selection is made
    Given the user is on the summary page
    When the user does not select any options for both the duration and payment sections
    And the user selects the type of change as "Other"
    And the user clicks on the Start Review button
    Then the user should see an error message indicating that "please fill the form"

  @Regression
  Scenario: Validate visibility of all components on the summary page
    Given the user is on the summary page
    Then the following components should be visible:
      | Change in Circumstances |
      | Summary                  |
      | Income                   |
      | Expenditure              |
      | Disposable Income        |
      | Term Left to Pay         |

