package pages;

import core.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static helpers.Locators.get;
import static helpers.Webdriversingleton.getDriver;

public class PageObject extends TestBase{
    private static final By USER_NAME_FIELD = get("loginPage.userNameField");
    private static final By PASSWORD_FIELD = get("loginPage.passwordField");
    private static final By LOGIN_BUTTON = get("loginPage.loginButton");
//    private static final By REMEMBER_CHECKBOX = get("login","value");

    public static void login(WebDriver driver, String user, String pass){
        getDriver().findElement(USER_NAME_FIELD).clear();
        getDriver().findElement(USER_NAME_FIELD).sendKeys(user);
        getDriver().findElement(PASSWORD_FIELD).clear();
        getDriver().findElement(PASSWORD_FIELD).sendKeys(user);
        getDriver().findElement(LOGIN_BUTTON).click();
    }

}
