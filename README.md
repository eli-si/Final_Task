# Selenium WebDriver Final Task

This is my homework project for automated testing course. Tests are written for Swag Labs website.

# Task

TASK DESCRIPTION:
Launch URL: https://www.saucedemo.com/
UC-1: Test Login form with empty credentials:

Type any credentials into "Username" and "Password" fields
Clear the inputs
Hit the "Login" button
Check the error messages: "Username is required"

UC-2: Test Login form with credentials by passing Username:

Type any credentials in username
Enter password
Clear the "Password" input
Hit the "Login" button
Check the error messages: "Password is required"

UC-3: Test Login form with credentials by passing Username & Password:

Type credentials in username which are under Accepted username are sections
Enter password as secret sauce
Click on Login and validate the title "Swag Labs" in the dashboard

Requirements:
Provide parallel execution, add logging for tests and use Data Provider to parametrize tests. Make sure that all tasks are supported by these 3 conditions: UC-1; UC-2; UC-3.
Please, add task description as README.md into your solution!
To perform the task use the various of additional options:

Test Automation tool: Selenium WebDriver
Project Builder: Maven
Browsers: 1) Edge; 2) Chrome
Locators: XPath
Test Runner: JUnit
[Optional] Patterns: 1) Abstract Factory; 2) Adapter; 3) Decorator
[Optional] Test automation approach: BDD
Assertions: Hamcrest
[Optional] Loggers: Log4j

# UC-1: Test Login with empty credentials
- Type any credentials into Username and Password fields
- Clear the inputs
- Hit the Login button
- Check the error messages: "Username is required"

# UC-2: Test Login with username only
- Type any credentials in username
- Enter password
- Clear the Password input
- Hit the Login button
- Check the error messages: "Password is required"

# UC-3: Test Login with valid credentials
- Type credentials in username which are under Accepted username sections
- Enter password as secret sauce
- Click on Login and validate the title "Swag Labs" in the dashboard

# Requirements from task
- Selenium WebDriver
- Maven
- Browsers: Edge and Chrome
- Locators: XPath
- Test Runner: JUnit
- Page Object Pattern


# What I used

- Java 11+
- Maven 3.6+
- Selenium WebDriver 4.15.0
- JUnit 5.10.1
- WebDriverManager 5.6.2
- Chrome or Edge browser

# How to run tests

# Chrome (default):

mvn clean test


# Edge browser:

mvn clean test -Dbrowser=edge


Note: If Edge tests fail with network error, you need to download Edge driver manually.

# How to setup Edge driver manually

1. Check your Edge version:
   - Open Edge browser
   - Go to edge://settings/help
   - Remember the version number (for example: 130.0.2849.68)

2. Download driver:
   - Go to https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
   - Download the version that matches your Edge

3. Extract and setup

4. Run tests with Edge:
   
   mvn clean test -Dbrowser=edge
   

# Test Results

All tests pass successfully:

- UC-1: Tests empty login - expects "Username is required" error
- UC-2: Tests login with only username - expects "Password is required" error  
- UC-3: Tests valid login - expects successful login to Products page

# Technologies Used

- Selenium WebDriver - for browser automation
- JUnit 5 - for running tests
- WebDriverManager - for automatic driver setup
- Maven - for building project
- Page Object Pattern - for organizing page elements
