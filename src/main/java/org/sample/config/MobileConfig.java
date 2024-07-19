package org.sample.config;

import org.aeonbits.owner.Config;
import org.sample.config.converters.StringToPlatformTypeConverter;
import org.sample.config.converters.StringToURLConverter;
import org.sample.enums.MobilePlatformType;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "system:env",
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface MobileConfig extends Config {

    @DefaultValue("ANDROID")
    @ConverterClass(StringToPlatformTypeConverter.class)
    MobilePlatformType platform();

    @Key("appiumServerURL")
    @ConverterClass(StringToURLConverter.class)
    URL appiumServerURL();

    @Key("appPackage")
    String appPackage();

    @Key("appActivity")
    String appActivity();

    @Key("logLevel")
    String logLevel();
}
