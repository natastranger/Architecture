package helpers;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

/**
 * Created by Admin on 21.01.2015.
 */
public class Actions {

    public static void takeScreeshot(WebDriver driver, String path) {
        try {
            TakesScreenshot shooter = (TakesScreenshot) driver;
            File screen = shooter.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screen, new File(path));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
