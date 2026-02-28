Gmail Login Automation - Selenium Data Driven Framework

Project Description

This project automates Gmail login functionality using Selenium WebDriver.
Test data (Email & Password) is read from an Excel file using Apache POI.
The framework is built using Java and Maven without TestNG.

The project demonstrates:
- Data Driven Testing
- WebDriverWait implementation (no Thread.sleep)
- Excel integration with Selenium
- Basic automation framework structure



 ----------------Technologies Used

- Java
- Selenium WebDriver
- Apache POI
- Maven
- Eclipse IDE
- Google Chrome Browser

------------------Test Data
Test data is stored in:

src/test/resources/testdata.xlsx
----------------Test Scenarios Covered

- Verify Gmail login page loads
- Login with valid email & invalid password
- Login with invalid email
- Verify blank email validation
- Verify blank password validation



------------------ Features

- Data Driven Testing using Excel
- Uses WebDriverWait instead of Thread.sleep
- Dynamic test execution for multiple test data rows
- Basic exception handling
- Clean and simple Maven project structure
