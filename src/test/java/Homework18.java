import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework18 extends BaseTest {

    @Test
    public void playSong() {
        provideEmail("denise626@hotmail.com");
        providePassword();
        clickSubmitBtn();

        WebElement songLink = driver.findElement(By.cssSelector("a[href='#!/songs']"));
        songLink.click();

        WebElement playSong = driver.findElement(By.xpath("//tr[@class='song-item']"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Actions act = new Actions(driver);
        act.doubleClick(playSong).perform();

        WebElement soundBarPlaySong = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        Assert.assertTrue(soundBarPlaySong.isDisplayed());

        //Code below is what I had above initially and it did not work.
        //WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid = 'play-btn']"));
        //songIsPlaying.click();

        //Assert.assertEquals(playSong, songIsPlaying);
    }
}
