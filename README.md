# ui-automation-selenium-cucumber

## Project Overview

This project automates the testing of the DFH Review Portal using Selenium WebDriver and the Cucumber framework. It
includes integration with Allure for test reporting and uses Maven for dependency management and build execution

## Key features

* Automated functional testing of the web application.
* Behavior-driven development (BDD) approach with Cucumber.
* Cross-browser testing capability.
* Integrated reporting with Allure for detailed test results.
* Seamless WebDriver management using WebDriverManager.
* Centralized logging with Log4j.

## Tech Stack

* Programming Language: Java 17
* Frameworks: Selenium WebDriver, Cucumber
* Build Tool: Maven
* Reporting Tool: Allure
* Logging Library: Log4j

## Prerequisites

1. Java 17 or higher installed.
2. Maven installed and configured.
3. An IDE like IntelliJ IDEA or Eclipse.
4. Browser drivers (managed automatically by WebDriverManager).

## Setup Instructions

1. Clone the Repository:<br>
   `git clone <repository-url>`<br>
   `cd DFH-Review-Portal-Automation`<br>


2. **Install Dependencies:**
   Run the following command to install all required dependencies:<br>
   `mvn clean install`


3. **Run Tests:**<br>
   ` mvn test -Dtest=TestRunner`


4. **Generate Allure Report:** After running tests, generate the Allure report:<br>
    * `allure generate target/allure-results --clean -o target/allure-report`
    * `allure open target/allure-report`

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Support

If you encounter any issues, please open an issue on the GitHub repository or contact the maintainers.
