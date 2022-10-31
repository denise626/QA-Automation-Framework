import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() {

        WebDriver driver = new ChromeDriver();
        provideEmail("denise626@hotmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();

        WebElement choosePlaylist = driver.findElement(By.xpath("//li[@class = 'playlist playlist'][2]//a"));
        wait.until(ExpectedConditions.elementToBeClickable(choosePlaylist)).click();
        WebElement deleteSongPlaylist = driver.findElement(By.xpath("//button[@title='Delete this playlist']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Delete this playlist']"))).click();

        Assert.assertFalse(deleteSongPlaylist.isDisplayed());
    }
}




