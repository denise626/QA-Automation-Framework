import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

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

        System.setProperty("webdriver.gecko.driver", "geckodriver");
        driver = Lambdatest.pickBrowser(System.getProperty("browser"));
        threadDriver = new ThreadLocal<>();
        threadDriver.set(driver);

        actions = new Actions(getDriver());
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        url = baseURL;
        getDriver().get(url);
    }

    public static WebDriver getDriver() {
        return threadDriver.get();
    }

    public class Lambdatest {

        public static RemoteWebDriver driver = null;
        String username = "kiser.denise1023";
        String accessKey = "9bm8RIGFBUb8nsv7S3Go7hAQBfxEt3ic335cAzfsnC30rT1C0t";

        @BeforeTest
        public void setUp() throws Exception {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("version", "107.0");
            capabilities.setCapability("platform", "Windows 10");
            capabilities.setCapability("resolution", "1024x768");
            capabilities.setCapability("build", "First Test");
            capabilities.setCapability("name", "Sample Test");
            capabilities.setCapability("network", true); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("video", true); // To enable video recording
            capabilities.setCapability("console", true); // To capture console logs

            try {
                driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            }
        }

        public static WebDriver pickBrowser(String browser) throws MalformedURLException {
            DesiredCapabilities caps = new DesiredCapabilities();
            String gridURL = "http://172.31.128.1:4444";
            switch (browser) {
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                    return driver = new FirefoxDriver();
                case "safari":
                    return driver = new SafariDriver();
                case "grid-safari":
                    caps.setCapability("browserName", "safari");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                case "grid-firefox":
                    caps.setCapability("browserName", "firefox");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                case "grid-chrome":
                    caps.setCapability("browserName", "chrome");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                case "cloud":
                    return lambdaTest();
                default:
                    return driver = new ChromeDriver();
            }
        }

        @AfterMethod
        public static void tearDownBrowser(WebDriver getDriver) {
            getDriver.quit();
            threadDriver.remove();
        }
    }
}
