import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

        WebElement playSong = driver.findElement(By.xpath("//section[@id='recentlyPlayedWrapper']//tr[@class='song-item']"));
        playSong.click();

        WebElement songIsPlaying = driver.findElement(By.cssSelector("[data-testid = 'play-btn']"));
        songIsPlaying.click();

        Assert.assertEquals(playSong, songIsPlaying);
    }
}
