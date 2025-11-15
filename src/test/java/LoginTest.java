import org.junit.jupiter.api.Test;
import pages.InventoryPage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {
    
    // UC-1: Login with empty credentials
    @Test
    public void testLoginWithEmptyCredentials() {
        System.out.println("Test UC-1: Login with empty username and password");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.clickLogin();
        
        assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed");
        String errorText = loginPage.getErrorMessage();
        assertTrue(errorText.contains("Epic sadface: Username is required"), 
                   "Error should mention username is required");
        
        System.out.println("UC-1 passed: " + errorText);
    }
    
    // UC-2: Login with username only
    @Test
    public void testLoginWithUsernameOnly() {
        System.out.println("Test UC-2: Login with username only");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.clickLogin();
        
        assertTrue(loginPage.isErrorDisplayed(), "Error message should be displayed");
        String errorText = loginPage.getErrorMessage();
        assertTrue(errorText.contains("Epic sadface: Password is required"), 
                   "Error should mention password is required");
        
        System.out.println("UC-2 passed: " + errorText);
    }
    
    // UC-3: Login with valid credentials
    @Test
    public void testLoginWithValidCredentials() {
        System.out.println("Test UC-3: Login with valid credentials");
        
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.isOpened(), "Inventory page should be opened");
        assertEquals("Products", inventoryPage.getTitle(), "Page title should be Products");
        
        System.out.println("UC-3 passed: Successfully logged in");
    }
}
