package pages;

import helpers.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import static helpers.Locators.get;

/**
 * Created by HP-G62 on 19.01.2015.
 */
public class PageObject {
    private static final By USER_NAME_FIELD = Locators.getLocator("loginPage.userNameField");
    private static final By PASSWORD_FIELD = Locators.getLocator("loginPage.passwordField");
    private static final By LOGIN_BUTTON = Locators.getLocator("loginPage.loginButton");
    private static final By REMEMBER_CHECKBOX = get("login", temp)

    public static void login (WebDriver driver, String user, String pass){
        driver.findElement(USER_NAME_FIELD).clear();
        driver.findElement(USER_NAME_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).clear();
        driver.findElement(PASSWORD_FIELD).sendKeys(user);
        driver.findElement(LOGIN_BUTTON).click();

    }

}
