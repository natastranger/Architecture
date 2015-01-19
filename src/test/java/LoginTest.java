import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

/**
 * Created by HP-G62 on 19.01.2015.
 */
public class LoginTest {
    private static final String BASE_URL = "http://the-internet.herokuapp.com/";
    private WebDriver driver;

    @BeforeMethod
    public void before() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        sleep(3000);
    }

    @AfterMethod
    public void after() {
        driver.close();
    }

    @Test
    public void formAuthenticationPositiveTest() throws InterruptedException {
        WebElement ref = driver.findElement(By.linkText("Form Authentication"));
        ref.click();
        WebElement userNameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement buttonLogin = driver.findElement(By.className("radius"));

        Assert.assertEquals(userNameInput.getText(), "");
        Assert.assertEquals(passwordInput.getText(), "");

        userNameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword!");
        buttonLogin.click();

        Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("You logged into a secure area!"));
    }

}
