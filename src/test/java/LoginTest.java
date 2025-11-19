import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {
    
    // UC-1: Login with empty credentials
    @Test
    public void testLoginWithEmptyCredentials() {
        System.out.println("Test UC-1: Login with empty username and password");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}

        loginPage.clickLogin();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed");
        String errorText = loginPage.getErrorMessage();
        System.out.println("ACTUAL ERROR TEXT: [" + errorText + "]");

        assertTrue(errorText.contains("Username is required"),
                "Error should mention username is required. Actual: " + errorText);

        System.out.println("UC-1 passed: " + errorText);
    }
    
    // UC-2: Login with username only
    @Test
    public void testLoginWithUsernameOnly() {
        System.out.println("Test UC-2: Login with username only");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterUsername("standard_user");try { Thread.sleep(800); } catch (InterruptedException e) {}
        loginPage.clickLogin();
        try { Thread.sleep(1500); } catch (InterruptedException e) {}

        assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed");
        String errorText = loginPage.getErrorMessage();
        System.out.println("ACTUAL ERROR TEXT: [" + errorText + "]");

        assertTrue(errorText.contains("Password is required"),
                "Error should mention password is required. Actual: " + errorText);

        System.out.println("UC-1 passed: " + errorText);
    }
    
    // UC-3: Login with valid credentials
    @Test
    public void testLoginWithValidCredentials() {
        System.out.println("Test UC-3: Login with valid credentials");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterUsername("standard_user");
        try { Thread.sleep(800); } catch (InterruptedException e) {}
        loginPage.enterPassword("secret_sauce");
        try { Thread.sleep(800); } catch (InterruptedException e) {}
        loginPage.clickLogin();
        try { Thread.sleep(2000); } catch (InterruptedException e) {}

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.isOpened(), "Inventory page should be opened");
        assertEquals("Products", inventoryPage.getTitle(), "Page title should be Products");
        
        System.out.println("UC-3 passed: Successfully logged in");
    }
}
