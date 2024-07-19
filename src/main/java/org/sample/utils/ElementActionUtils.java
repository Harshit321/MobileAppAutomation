package org.sample.utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.sample.driver.manager.DriverManager;
import org.sample.utils.logger.LoggerUtil;

import java.util.Map;

public class ElementActionUtils {

    static final LoggerUtil LOGGER = new LoggerUtil(ElementActionUtils.class);

    public static By getFindElement(Map<String, String> map) {
        switch (map.get("strategy")) {
            case "id":
                return By.id(map.get("value"));
            case "xpath":
                return By.xpath(map.get("value"));
            case "className":
                return By.className(map.get("value"));
            case "name":
                return By.name(map.get("value"));
            case "accessibilityId":
                return AppiumBy.accessibilityId(map.get("value"));
            case "uIAutomator":
                return AppiumBy.androidUIAutomator(map.get("value"));
            case "classChain":
                return AppiumBy.iOSClassChain(map.get("value"));
            case "predicateString":
                return AppiumBy.iOSNsPredicateString(map.get("value"));
            default:
                LOGGER.error("strategy not found.");
        }
        throw new IllegalArgumentException("Invalid strategy.");
    }

    public static void waitAndClick(Map<String, String> map) {
        DriverManager.getDriver().findElement(getFindElement(map)).click();
    }

    public static void setText(Map<String, String> map, String text) {
        LOGGER.info("Setting text: " + text +
                "  -> on the element with locator map:" + map.toString());
        DriverManager.getDriver().findElement(getFindElement(map)).sendKeys(text);
    }

    public static String getText(Map<String, String> map) {
        return DriverManager.getDriver().findElement(getFindElement(map)).getText();
    }

    public static void click(Map<String, String> map) {
        LOGGER.info("Clicking on the element with locator map:" + map.toString());
        DriverManager.getDriver().findElement(getFindElement(map)).click();
    }

}
