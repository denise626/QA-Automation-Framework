package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayingASong extends LoginPage {

    WebDriver driver;

    public PlayingASong(WebDriver givenDriver) {
        super(givenDriver);
    }


    @Test
    public void playSong() {
        provideEmail("denise626@hotmail.com");
        providePassword("te$t$tudent");
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
    }
}

