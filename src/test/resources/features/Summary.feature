Feature: Summary Page Functionality Validation

  @Regression
  Scenario: Validate the Summary page functionality
    Given the user is on the summary page
    Then the user should be able to see the Circumstances and Summary sections
    When the user selects Yes for the duration and payment sections
    And the user selects the type of change as "change income"
    And the user clicks on the Start Review button
    Then the user should be navigated to the household page
    And within the Household page, the user should be able to see the configured users

#  Scenario: Validate navigating from the summary page to the household page
#    Given the user is on the summary page
#    When the user selects the "Yes" option for the duration and payments sections
#    And the user clicks on the "Start Review" button
#    Then the user should be navigated to the "Household" page
#    And the user should see the configured users on the Household page
#
#  Scenario: Validate error handling when no selection is made
#    Given the user is on the summary page
#    When the user does not select any option for the "Changes in Circumstances" or "Summary" sections
#    And the user clicks on the "Start Review" button
#    Then the user should see an error message indicating that all fields must be filled
#
#  Scenario: Validate all visible texts on the Summary page
#    Given the user is on the summary page
#    Then the following texts should be visible:
#      | Changes in Circumstances |
#      | Summary                  |
#      | Will this change impact you for more than 2 months? |
#      | Do you believe this change will impact your payment? |
#      | What type of change is it? |

