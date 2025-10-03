# Automation Exercise Task 1

## Overview
This project is a comprehensive automated testing suite for the Automation Exercise website. It uses Selenium WebDriver and TestNG, following the Page Object Model (POM) design pattern to ensure maintainability and scalability. The suite covers major user flows such as sign up, sign in, product browsing, cart management, checkout, payment, and contact forms.

## Features
- Automated end-to-end tests for all main website functionalities
- Page Object Model for clean separation of page logic
- Data-driven testing using JSON files
- Configurable browser and environment settings
- ExtentReports integration for detailed test reports
- Integrated logging (Log4j2) for cleaner, more maintainable, and traceable test execution

## Technologies Used
- Java
- Selenium WebDriver
- TestNG
- ExtentReports
- Log4j2 (Logging)
- JSON for test data

## Project Structure
```
src/
  main/
    java/
      pages/         # Page Object classes (AddToCartPage, HomePage, etc.)
      utiles/        # Utility classes (helpers, config, data readers, driver management, reporting, logging)
    resources/
      Config.properties  # Environment configuration
      log4j2.properties  # Logging configuration
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
4. (Optional) Adjust `log4j2.properties` for custom logging preferences.
5. Install dependencies:
   ```
   mvn clean install
   ```

## Running Tests
To execute all tests and generate reports:
```
mvn test
```
Test results and ExtentReports will be available in the `test-output` directory. Log files are generated in `test-output/Logs` for detailed execution traces.

## Test Data
Test scenarios use data from JSON files in `src/test/resources` for addresses, credit cards, products, and more. You can modify these files to add or update test cases.

## Logging
All test actions and important events are logged using Log4j2, making it easier to debug, monitor, and maintain the test suite. Log files are stored in `test-output/Logs`.

## Reporting
After running tests, detailed HTML reports are generated in the `test-output` folder for easy review of test outcomes.

## Contribution
Feel free to fork the repository and submit pull requests for improvements or new test cases.

## License
This project is for educational and demonstration purposes.

## E2E Scenarios
This test suite covers the following end-to-end user journeys:

- **Sign Up**: Automates user registration, including entering personal details, address, and verifying account creation.
- **Sign In**: Validates login functionality with email and password, ensuring successful authentication.
- **Product Search and View**: Searches for products, verifies product visibility, and views product details.
- **Add to Cart**: Adds multiple products to the cart, verifies quantities, prices, and total amounts.
- **Checkout**: Proceeds to checkout, verifies delivery address, and places an order.
- **Payment**: Enters credit card details and confirms payment.
- **Contact Us**: Submits the contact form and verifies success message.
- **Log Out**: Logs out and checks for correct redirection.
- **Product Details**: Verifies product name, category, and price on the product details page.
