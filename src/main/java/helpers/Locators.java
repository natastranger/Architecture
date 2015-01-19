package helpers;

import org.openqa.selenium.By;

import java.io.InputStream;
import java.lang.Exception;
import java.lang.System;
import java.util.Properties;

/**
 * Created by HP-G62 on 18.01.2015.
 */
public class Locators {
    private static Properties LOCATORS;

    private enum LocatorType {
        id, name, css, xpath, tag, text, partText
    }

    static {
        LOCATORS = new Properties();
        try {
            InputStream in = Locators.class.getResourceAsStream("/locators.properties");
            LOCATORS.load(in);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static By get(String elenentName) {
        return
    }

    public static By get(String locatorName,)

    public By getLocator(String elementName, String value) {
        String[] values = LOCATORS.getProperty(elementName).split("=", 2);
        LocatorType locatorType = new LocatorType.valueOf(values[0]);
        switch (locatorType) {

            case id: {
                return By.id(values[1]);
            }

            case name: {
                return By.className(values[1]);
            }

            case css: {
                return By.cssSelector(values[1]);
            }

            case xpath: {
                return By.xpath(values[1]);
            }

            case tag: {
                return By.tagName(values[1]);
            }

            case text: {
                return By.linkText(values[1]);
            }

            case partText: {
                return By.partialLinkText(values[1]);
            }

            default: {
                throw new IllegalArgumentException("Type " + values[0] + " is not supported");
            }
        }
    }


    private By getLocator(String elementName, String value) {
        String[] values = LOCATORS.getProperty(elementName).split("=", 2);
        LocatorType locatorType = new LocatorType.valueOf(values[0]);
        switch (locatorType) {

            case id: {
                return By.id(values[1]);
            }

            case name: {
                return By.className(values[1]);
            }

            case css: {
                return By.cssSelector(values[1]);
            }

            case xpath: {
                return By.xpath(values[1]);
            }

            case tag: {
                return By.tagName(values[1]);
            }

            case text: {
                return By.linkText(values[1]);
            }

            case partText: {
                return By.partialLinkText(values[1]);
            }

            default: {
                throw new IllegalArgumentException("Type " + values[0] + " is not supported");
            }
//Темплейт создаетс для однотипных локаторов
        }


    }
}