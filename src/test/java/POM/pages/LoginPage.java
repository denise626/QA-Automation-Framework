package POM.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class LoginPage extends BasePage {

    private @FindBy(css = "[type='email']")
    WebElement emailField;

    private @FindBy(css = "[type='password']")
    WebElement passwordField;
    private @FindBy(css = "[type='submit']")
    WebElement submitButtonLocator;

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    public LoginPage clickSubmitBtn() {
        submitButtonLocator.click();
        return this;
    }
    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public void login() {
        provideEmail("denise626@hotmail.com").providePassword("te$t$tudent").clickSubmitBtn();
    }
}
