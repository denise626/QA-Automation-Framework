import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class homework14AK {
    @Test

    public static void RegistrationPanel() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = "https://bbb.testpro.io/";
        driver.get(url);

        WebElement registrationLink = driver.findElement(By.cssSelector("[id= 'hel']"));
        registrationLink.click();
        WebElement registerButton = driver.findElement(By.cssSelector("[id= 'button']"));
        Assert.assertTrue(registerButton.isDisplayed());
        Thread.sleep(5000);
        driver.quit();
    }
}





