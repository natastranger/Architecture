package core;

import helpers.Webdriversingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    private static final String BASE_URL = "https://github.com/login ";
    private WebDriver driver;


//    @BeforeMethod
//    public void before() throws InterruptedException {
//        driver.
//        String browser = System.getProperty("browser", "phantomjs");
//        System.getProperty("Current browser is : ", browser);
//        Webdriversingleton.initDriver(browser).get(BASE_URL);
//        Webdriversingleton wd = new Webdriversingleton();
//        Page
    }

//    @AfterMethod
//    public void after() {
//        driver.quit();
//    }
//}
