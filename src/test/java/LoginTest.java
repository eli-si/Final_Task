import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.InventoryPage;
import pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);
    
    // UC-1: Login with empty credentials
    @Test
    public void testLoginWithEmptyCredentials() {
        logger.info("Test UC-1: Login with empty username and password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        loginPage.clickLogin();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed");
        String errorText = loginPage.getErrorMessage();

        assertTrue(errorText.contains("Username is required"),
                "Error should mention username is required. Actual: " + errorText);

        logger.info("UC-1 passed: {}", errorText);
    }

    @ParameterizedTest(name = "UC-2: Login with username [{0}]")
    @CsvSource({
            "standard_user",
            "locked_out_user",
            "problem_user"
    })
    
    // UC-2: Login with username only

    public void testLoginWithUsernameOnly(String username) {
        logger.info("Test UC-2: Login with username only", username);
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterUsername(username);
        try { Thread.sleep(800); } catch (InterruptedException e) {}
        loginPage.clickLogin();
        try { Thread.sleep(1500); } catch (InterruptedException e) {}

        assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed");
        String errorText = loginPage.getErrorMessage();

        assertTrue(errorText.contains("Password is required"),
                "Error should mention password is required. Actual: " + errorText);

        logger.info("UC-2 passed with username {}: {}", username, errorText);
    }

    @ParameterizedTest(name = "UC-3: Login with valid credentials [{0}]")
    @CsvSource({
            "standard_user, secret_sauce",
            "problem_user, secret_sauce",
            "performance_glitch_user, secret_sauce"
    })
    
    // UC-3: Login with valid credentials

    public void testLoginWithValidCredentials(String username, String password) {
        logger.info("Test UC-3: Login with valid credentials - {}", username);

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterUsername(username);
        try { Thread.sleep(800); } catch (InterruptedException e) {}
        loginPage.enterPassword("secret_sauce");
        try { Thread.sleep(800); } catch (InterruptedException e) {}
        loginPage.clickLogin();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        try {
            ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                    "var buttons = document.querySelectorAll('button');" +
                            "for(var i=0; i<buttons.length; i++){" +
                            "  if(buttons[i].textContent.includes('OK')){" +
                            "    buttons[i].click();" +
                            "    break;" +
                            "  }" +
                            "}"
            );
            System.out.println("Closed password popup via JavaScript");
            Thread.sleep(500);
        } catch (Exception e) {
            logger.debug("Password popup did not appear");
        }

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.isOpened(), "Inventory page should be opened");
        assertEquals("Products", inventoryPage.getTitle(), "Page title should be Products");

        logger.info("UC-3 passed: Successfully logged in with {}", username);
    }
}
