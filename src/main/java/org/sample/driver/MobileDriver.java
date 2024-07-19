package org.sample.driver;

import io.appium.java_client.AppiumDriver;
import org.sample.config.factory.MobileConfigFactory;
import org.sample.driver.factory.DriverFactory;
import org.sample.driver.manager.DriverManager;

import java.util.Objects;

public final class MobileDriver {

    private MobileDriver() {
    }

    public static void initDriver(String deviceId) {
        AppiumDriver driver = DriverFactory.getDriver(MobileConfigFactory.getConfig().platform(), deviceId);
        DriverManager.setDriver(driver);
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }

}
