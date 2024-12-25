Feature: Login Page
  As a user,
  I want to log in to the application,
  So that I can access secure areas of the website.

  @Regression
  Scenario: Validate the Login page functionality
    Given the user on the login page
    When the user enter valid credentials
    And click on login button
    Then user should be redirect to customer details page
    When user enter valid customer id and click on submit button
    Then user should should be navigate to homepage