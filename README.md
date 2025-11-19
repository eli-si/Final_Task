# Selenium WebDriver Final Task

This is my homework project for automated testing course. Tests are written for Swag Labs website.

# Task

URL: https://www.saucedemo.com/

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
   - Get the Windows 64-bit version

3. Extract and setup:
   - Extract the downloaded zip file
   - Create folder: C:\WebDrivers
   - Put msedgedriver.exe into C:\WebDrivers
   - The code will automatically use it if WebDriverManager fails

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
