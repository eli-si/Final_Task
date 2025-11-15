package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;
    
    private By pageTitle = By.xpath("//span[@class='title']");
    
    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }
    
    public boolean isOpened() {
        try {
            return driver.findElement(pageTitle).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
