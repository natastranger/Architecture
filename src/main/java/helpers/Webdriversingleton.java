package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

//import java.lang.ref.PhantomReference;

public class Webdriversingleton {

    private static WebDriver driver;

    public Webdriversingleton() {

    }

    public static WebDriver getDriver() {
        if (driver != null) {
            return driver;
        } else {
            return new ChromeDriver();
        }
    }

    public static WebDriver initDriver(String browser) throws MalformedURLException {
        String remote = System.getProperty("remote", "");
        if (remote.length() > 0) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (browser) {
                case "firefox": {
                    capabilities.setBrowserName("firefox");
                    break;
                }

                case "chrome": {
                    capabilities.setBrowserName("chrome");
                    break;
                }

                case "ie": {
                    capabilities.setBrowserName("ie");
                    break;
                }

                case "htmlunit": {
                    capabilities.setBrowserName("htmlunit");
                    break;
                }

                case "phantomjs": {
                    capabilities.setBrowserName("phantomjs");
                    break;
                }

                default: {
                    capabilities.setBrowserName("firefox");
                }
            }
            driver = new RemoteWebDriver(new URL(remote), capabilities);

        } else {
            switch (browser) {
                case "firefox": {
                    driver = new FirefoxDriver();
                    break;
                }

                case "chrome": {
                    driver = new ChromeDriver();
                    break;
                }

                case "ie": {
                    driver = new InternetExplorerDriver();
                    break;
                }

                case "htmlunit": {
                    driver = new HtmlUnitDriver();
                    break;
                }

                case "phantomjs": {
//                    driver = new Phantom();
                    break;
                }

                default: {
                    driver = new FirefoxDriver();
                }
            }
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(4, TimeUnit.SECONDS);
        return driver;


    }
}

