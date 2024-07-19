package org.sample.app.tests.testbase;

import org.sample.appiumservice.AppiumServiceUtils;
import org.sample.driver.MobileDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod
    @Parameters("devices")
    public void setup(String deviceId) {
        AppiumServiceUtils.startAppiumServer();
        MobileDriver.initDriver(deviceId);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        MobileDriver.quitDriver();
        AppiumServiceUtils.stopAppiumServer();
    }


}
