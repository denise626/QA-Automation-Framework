package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlayingDefinitions  {
    WebDriver driver = LoginStepDefinitions.driver;
    WebDriverWait wait = LoginStepDefinitions.wait;


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

