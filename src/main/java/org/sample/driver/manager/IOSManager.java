package org.sample.driver.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.sample.config.factory.MobileConfigFactory;

public final class IOSManager {

    private IOSManager() {
    }

    public static AppiumDriver getDriver(String deviceId) {
        IOSDriver driver = null;
        XCUITestOptions options = new XCUITestOptions();
        // Set XCUITestOptions
        driver = new IOSDriver(MobileConfigFactory.getConfig().appiumServerURL(), options);
        return driver;
    }

}
