import POM.pages.HomePage;
import POM.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void LoginEmptyEmailPasswordTest() {
        String expectedResultUrl = "https://bbb.testpro.io/";
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedResultUrl);
    }

    @Test
    public void LoginValidEmailPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.login();

        Assert.assertTrue(homePage.isUserAvatarDisplayed());
    }
}