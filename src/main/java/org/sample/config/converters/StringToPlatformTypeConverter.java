package org.sample.config.converters;

import org.aeonbits.owner.Converter;
import org.sample.enums.MobilePlatformType;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToPlatformTypeConverter implements Converter<MobilePlatformType> {

    @Override
    public MobilePlatformType convert(Method method, String platformType) {
        Map<String, MobilePlatformType> stringMobilePlatformTypeMap =
                Map.of(
                        "ANDROID", MobilePlatformType.ANDROID,
                        "IOS", MobilePlatformType.IOS
                );
        return stringMobilePlatformTypeMap.getOrDefault(platformType.toUpperCase()
                , MobilePlatformType.ANDROID);
    }
}
