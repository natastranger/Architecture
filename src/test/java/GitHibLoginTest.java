import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PageObject;

/**
 * Created by HP-G62 on 19.01.2015.
 */
public class GitHibLoginTest extends TestBase {
    private WebDriver driver;

    @Test
    public void loginTest() {
        PageObject page = new PageObject();
        page.login(driver,"nata","mad");
        Assert.assertTrue(driver.findElement(By.className("title")).getText().contains("Welcome to GitHub!"));
    }

}
