package org.sample.appiumservice;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public final class AppiumServiceUtils {

    private AppiumServiceUtils() {
    }

    private static AppiumDriverLocalService appiumDriverLocalService;

    public static AppiumDriverLocalService getAppiumDriverLocalService() {
        return appiumDriverLocalService;
    }

    public static void setAppiumDriverLocalService(AppiumDriverLocalService service) {
        appiumDriverLocalService = service;
    }

    public static void startAppiumServer() {
        appiumDriverLocalService = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        appiumDriverLocalService.start();
        setAppiumDriverLocalService(appiumDriverLocalService);
    }

    public static void stopAppiumServer() {
        getAppiumDriverLocalService().stop();
    }


}
