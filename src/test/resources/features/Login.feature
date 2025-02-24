Feature: Login Functionality

  @Regression
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters valid credentials
    Then the user should be successfully logged into the application
    And the user should see welcome message text

  @Regression
  Scenario Outline: Successful loin for multiple users
    Given the user is on the login page
    When the user enters "<userName>" and "<password>" on the login page
    Then the user should be successfully logged into the application
    And the user should see "<successMessage>" message text

    Examples:
      | userName | password             | successMessage  |
      | practice | SuperSecretPassword! | Hi, practice! |
      | jhon     | Text@123             | Hi, jhon!    |
    