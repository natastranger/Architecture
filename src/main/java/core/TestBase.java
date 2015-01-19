package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class TestBase {

    private static final String BASE_URL = "https://github.com/login ";
    private WebDriver driver;

    @BeforeMethod
    public void before() throws InterruptedException {
        String browser = System.getProperty("browser", "firefox");
        driver = initDriver("chrome");
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

    private WebDriver initDriver(String browser) {
        switch (browser) {
            case "firefox": {
                return new FirefoxDriver();
            }
            case "chrome": {
                return new ChromeDriver();
            }
            default:
                return new FirefoxDriver();
        }
    }
}
