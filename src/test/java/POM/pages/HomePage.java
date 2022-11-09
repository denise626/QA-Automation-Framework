package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(css = "img.avatar")
    WebElement avatarLocator;


    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public boolean isUserAvatarDisplayed() {
        //return driver.findElement(avatarLocator).isDisplayed();
        avatarLocator.isDisplayed();
        return this.isUserAvatarDisplayed();
    }
}
