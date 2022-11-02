import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {

        provideEmail("denise626@hotmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
        contextClickPlaylist();
        editPlaylist();
        inputNewPlaylistName();
        doesNewPlaylistExist();
    }
    public void contextClickPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > a")));
        WebElement webElement = driver.findElement(By.cssSelector("#playlists > ul > li:nth-child(3) > a"));
        actions.contextClick(webElement).perform();
    }
    public void editPlaylist() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#playlists > ul > li:nth-child(3) > nav > ul > li:nth-child(1)")));
    }
    public void inputNewPlaylistName() {
        WebElement playlistInputField = driver.findElement(By.cssSelector("input[name = 'name']"));
        playlistInputField.sendKeys((Keys.chord(Keys.CONTROL, "a", Keys.BACK_SPACE )));
        playlistInputField.sendKeys("April's New and Edited Playlist");
        playlistInputField.sendKeys(Keys.ENTER);
    }
    public boolean doesNewPlaylistExist() {
        WebElement newPlaylistElement = driver.findElement(By.xpath("//a[text = 'April's New and Edited Playlist']"));
        return newPlaylistElement.isDisplayed();
    }
}
