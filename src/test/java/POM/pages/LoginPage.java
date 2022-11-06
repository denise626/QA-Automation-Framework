package POM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private By emailFieldLocator = By.cssSelector("[type = 'email']");
    private By passwordFieldLocator = By.cssSelector("[type = 'password']");
    private By submitButtonLocator = By.cssSelector("[type = 'email']");

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public void clickSubmitBtn() {
        driver.findElement(submitButtonLocator).click();
    }
    public void provideEmail(String email) {
        driver.findElement(emailFieldLocator).sendKeys(email);
    }
    public void providePassword(String password) {
        driver.findElement(passwordFieldLocator).sendKeys(password);
    }
    public void login() {
        provideEmail("denise626@hotmail.com");
        providePassword("te$t$tudent");
        clickSubmitBtn();
    }
}
