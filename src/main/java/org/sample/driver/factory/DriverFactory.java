package org.sample.driver.factory;

import io.appium.java_client.AppiumDriver;
import org.sample.driver.manager.AndroidManager;
import org.sample.driver.manager.IOSManager;
import org.sample.enums.MobilePlatformType;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public final class DriverFactory {

    private DriverFactory() {
    }

    private static final Map<MobilePlatformType, Function<String, AppiumDriver>> MAP =
            new EnumMap<>(MobilePlatformType.class);

    static {
        MAP.put(MobilePlatformType.ANDROID, AndroidManager::getDriver);
        MAP.put(MobilePlatformType.IOS, IOSManager::getDriver);
    }

    public static AppiumDriver getDriver(MobilePlatformType platformType, String deviceId) {
        return MAP.getOrDefault(platformType, AndroidManager::getDriver).apply(deviceId);
    }


}
