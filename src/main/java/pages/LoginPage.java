package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    
    private By usernameField = By.xpath("//input[@id='user-name']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");
    private By errorMessage = By.xpath("//h3[@data-test='error']");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public void open() {
        driver.get("https://www.saucedemo.com/");
    }
    
    public void enterUsername(String username) {
        WebElement field = driver.findElement(usernameField);
        field.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        WebElement field = driver.findElement(passwordField);
        field.sendKeys(password);
    }
    
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    
    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
    
    public boolean isErrorDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
