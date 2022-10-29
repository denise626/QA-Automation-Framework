import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() {

        WebDriver driver = new ChromeDriver();
        provideEmail("denise626@hotmail.com");
        providePassword();
        clickSubmitBtn();

        WebElement choosePlaylist = driver.findElement(By.cssSelector("[href = '#!/playlist/17356']"));
        choosePlaylist.click();
        WebElement deleteSongPlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        deleteSongPlaylist.click();

        Assert.assertFalse(deleteSongPlaylist.isDisplayed());
    }




}

