package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LoginStepDefinitions {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    public static void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Given("I open Login Page")
    public void iOpenLoginPage() {
        driver.get("https://bbb.testpro.io");
    }

    @When("I enter email {string}")
    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type= 'email']"))).sendKeys(email);
    }

    @And("I enter password {string}")
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type= 'password']"))).sendKeys(password);
    }
    @And("I submit")
    public void submit() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[type= 'submit']"))).click();
    }
    @Then("I am logged in HomePage")
    public void userIsLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }
    @AfterAll
    public static void closeBrowser() {
        driver.quit();
    }
}
