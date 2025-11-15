# Selenium WebDriver Homework

Automated tests for Swag Labs website using Selenium WebDriver and JUnit 5.


# How to Run

# Run all tests with Chrome (default):
```bash
mvn clean test
```

# Run tests with Edge:
```bash
mvn clean test -Dbrowser=edge
```

# Run specific test:
```bash
mvn test -Dtest=LoginTest#testLoginWithValidCredentials
```

# Test Cases

**UC-1**: Login with empty credentials  
**UC-2**: Login with username only  
**UC-3**: Login with valid credentials (standard_user / secret_sauce)
