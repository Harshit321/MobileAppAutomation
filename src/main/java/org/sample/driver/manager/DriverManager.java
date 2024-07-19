package org.sample.driver.manager;

import io.appium.java_client.AppiumDriver;

public final class DriverManager {
    private DriverManager() {}


    private static final ThreadLocal<AppiumDriver> MOBILE_DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return MOBILE_DRIVER_THREAD_LOCAL.get();
    }

    public static void setDriver(AppiumDriver driver) {
        MOBILE_DRIVER_THREAD_LOCAL.set(driver);
    }

    public static void unload() {
        MOBILE_DRIVER_THREAD_LOCAL.remove();
    }

}
