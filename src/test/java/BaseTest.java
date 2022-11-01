import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    static WebDriver driver;
    WebDriverWait wait;
    String url;

    @BeforeSuite
    public static void chromeConfigs() {
        // This is for Windows users
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @AfterMethod
    public void closeDownBrowser() {
        driver.quit();
    }
    public void clickSubmitBtn() {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type = 'submit']")));
        submitButton.click();
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type = 'email']")));
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type = 'password']")));
        passwordField.sendKeys(password);
    }
    @DataProvider(name ="invalidCredentials")
    public static Object[][] getCredentials() {

        return new Object[][]{
                {"invalid@class.com", "invalidPass"},
                {"d@class.com", ""},
                {"", ""},
        };
    }
}














