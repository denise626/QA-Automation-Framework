import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    static WebDriver driver;
    static String url;
    static Actions actions;
    static ThreadLocal<WebDriver> threadDriver;

    @BeforeSuite
    public static void chromeConfigs() {
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public static void launchBrowser(@Optional String baseURL) throws MalformedURLException {

        if (baseURL == null) {
            baseURL = "https://bbb.testpro.io";
        }
        threadDriver = new ThreadLocal<>();
        driver = pickBrowser("firefox");
        threadDriver.set(driver);
        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        url = baseURL;
        getDriver().get(url);
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public static WebDriver lambdaTest() throws MalformedURLException {
        String username = "khaledzamanqa";
        String authkey = "e33oiUgYlTNRArFJpW8NCYZmvEzDi9jIQC6qvdHg4UOxL82EHd";
        String hub = "@hub.lambdatest.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platform", "MacOS Catalina");
        caps.setCapability("resolution", "1440x900");
        caps.setCapability("browserName", "Safari");
        caps.setCapability("version", "13.0");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("plugin", "git-testng");
        return new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
    }

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        String gridURL = "http://192.168.1.67:1234";

        switch (browser) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                return driver = new FirefoxDriver();
            case "safari":
                return driver = new SafariDriver();
            case "grid-firefox":
                capabilities.setCapability("browserName", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-safari":
                capabilities.setCapability("browserName", "safari");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "grid-chrome":
                capabilities.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), capabilities);
            case "cloud":
                return lambdaTest();
            default:
                return driver = new ChromeDriver();
        }

    }

    @DataProvider(name = "invalidCredentials")
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"invalid@class.com", "invalidPass"},
                {"d@class.com", ""},
                {"", ""}
        };
    }


    @AfterMethod
    public static void tearDownBrowser() {
        getDriver().quit();
        threadDriver.remove();
    }
}
