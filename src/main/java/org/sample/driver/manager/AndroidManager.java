package org.sample.driver.manager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.sample.config.factory.MobileConfigFactory;

public final class AndroidManager {

    private AndroidManager() {
    }

    public static AppiumDriver getDriver(String deviceId) {
        AndroidDriver driver = null;
        UiAutomator2Options options = new UiAutomator2Options();
        options.setUdid(deviceId);
        options.setAppPackage(MobileConfigFactory.getConfig().appPackage());
        options.setAppActivity(MobileConfigFactory.getConfig().appActivity());
        driver = new AndroidDriver(MobileConfigFactory.getConfig().appiumServerURL(), options);
        return driver;
    }



}
