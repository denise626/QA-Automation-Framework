import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Homework19 extends BaseTest {
    @Test(dataProvider = "invalidCredentials", dataProviderClass = BaseTest.class)
    public void deletePlaylist() {
        provideEmail("denise626@hotmail.com");
        providePassword();
        clickSubmitBtn();

        WebElement choosePlaylist = driver.findElement(By.cssSelector("[href = '#!/playlist/17356']"));
        choosePlaylist.click();
        WebElement deleteSongPlaylist = driver.findElement(By.cssSelector("[id='extraTabAlbum']"));
        deleteSongPlaylist.click();

        Assert.assertFalse(deleteSongPlaylist.isDisplayed());
    }




}

