package stepDefinition;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class CreatingDefinitions {
    WebDriver driver;
    WebDriverWait wait;
    WebElement createPlaylist = driver.findElement(By.xpath("//*[@title='Create a new playlist']"));

    @Before

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Given("I am logged in on homepage")
    public void userIsLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }
    @When("I click on create a new playlist")
    public void creatingANewPlaylist() {
        //WebElement createPlaylist = driver.findElement(By.xpath("//*[@title='Create a new playlist']"));
        createPlaylist.click();
    }
    @Then("create playlist is displayed")
    public void playlistIsDisplayed() {
        Assert.assertTrue(createPlaylist.isDisplayed());
    }
}