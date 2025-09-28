# Automation Exercise Task 1

## Overview
This project is a comprehensive automated testing suite for the Automation Exercise website. It uses Selenium WebDriver and TestNG, following the Page Object Model (POM) design pattern to ensure maintainability and scalability. The suite covers major user flows such as sign up, sign in, product browsing, cart management, checkout, payment, and contact forms.

## Features
- Automated end-to-end tests for all main website functionalities
- Page Object Model for clean separation of page logic
- Data-driven testing using JSON files
- Configurable browser and environment settings
- ExtentReports integration for detailed test reports

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- ExtentReports
- JSON for test data

## Project Structure
```
src/
  main/
    java/
      pages/         # Page Object classes (AddToCartPage, HomePage, etc.)
      utiles/        # Utility classes (helpers, config, data readers, driver management, reporting)
    resources/
      Config.properties  # Environment configuration
  test/
    java/
      *.java         # Test classes for each user flow
    resources/
      *.json         # Test data files (addresses, credit cards, products, etc.)
pom.xml              # Maven build file
```

## Setup Instructions
1. Clone the repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Update `Config.properties` with your desired URL and browser.
4. Install dependencies:
   ```
   mvn clean install
   ```

## Running Tests
To execute all tests and generate reports:
```
mvn test
```
Test results and ExtentReports will be available in the `test-output` directory.

## Test Data
Test scenarios use data from JSON files in `src/test/resources` for addresses, credit cards, products, and more. You can modify these files to add or update test cases.

## Reporting
After running tests, detailed HTML reports are generated in the `test-output` folder for easy review of test outcomes.

## Contribution
Feel free to fork the repository and submit pull requests for improvements or new test cases.

## License
This project is for educational and demonstration purposes.

