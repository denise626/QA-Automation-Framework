import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homework17 extends BaseTest {

    @Test

    public void addSongToPlaylist() throws InterruptedException {

        provideEmailAddress();
        providePassword();
        clickSubmitButton();
        getDriver();

        WebElement allSongs = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        allSongs.click();

        WebElement songReactor = driver.findElement(By.xpath("//*[@id='songsWrapper']"));
        songReactor.click();

        WebElement addToButton = driver.findElement(By.cssSelector("button.btn-add-to"));
        addToButton.click();

        WebElement addToPlaylist = driver.findElement(By.cssSelector("li.playlist"));
        addToPlaylist.click();

        Assert.assertTrue(addToPlaylist.isDisplayed());

        Thread.sleep(5000);
    }
}



