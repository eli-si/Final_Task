import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {
    protected WebDriver driver;
    
    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        
        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("Starting Edge browser");
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Starting Chrome browser");
        }
        
        driver.manage().window().maximize();
    }
    
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed");
        }
    }
}
