package stepDefinition;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CreatingDefinitions {
    WebDriver driver = LoginStepDefinitions.driver;



    WebElement createPlaylist = driver.findElement(By.xpath("//*[@title='Create a new playlist']"));


    @When("I click on create a new playlist")
    public void creatingANewPlaylist() {
        createPlaylist.click();
    }

    @Then("create playlist is displayed")
    public void playlistIsDisplayed() {
        Assert.assertTrue(createPlaylist.isDisplayed());
    }
}

