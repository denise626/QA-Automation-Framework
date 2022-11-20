package stepDefinition;

import POM.pages.PlayingASong;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class PlayingDefinitions {
    WebDriver driver;
    WebDriverWait wait;

    @Before

    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Given("I am logged in")
    public void userIsLoggedIn() {
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.avatar"))).isDisplayed());
    }
    @When("I click on song link")
    public void songLinkIsClicked() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='#!/songs']"))).click();
    }
    @And("double click on song to play")
    public void doubleClickOnSongToPlay() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath ("//tr[@class='song-item']"))).click();
    }
    @Then("song will play")
    public void songIsPlaying() {
        WebElement soundBarPlaySong = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBarPlaySong.isDisplayed());
    }
}
