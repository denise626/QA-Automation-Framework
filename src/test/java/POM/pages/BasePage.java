package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage (WebDriver givenDriver) {
        driver = givenDriver;

        PageFactory.initElements(driver,this);
    }

    protected WebElement waitForVisibilityOfElement(WebElement webElementLocator) {
        return new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .visibilityOf(webElementLocator));
    }
}
