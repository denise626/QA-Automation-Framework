import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.time.Duration;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    static WebDriver driver;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        driver.get(url);
    }
    @AfterMethod
    public void closeDownBrowser() {
        driver.quit();
    }
    public void clickSubmitBtn() {
        WebElement submitButton = driver.findElement(By.cssSelector("[type = 'submit']"));
    }

    public void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("[type = 'email']"));
        emailField.click();
        emailField.sendKeys(email);
    }

    public void providePassword() {
        WebElement passwordField = driver.findElement(By.cssSelector("[type = 'password']"));
        passwordField.click();
        passwordField.sendKeys("te$t$tudent");
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






