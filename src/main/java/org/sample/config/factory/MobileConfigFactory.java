package org.sample.config.factory;

import org.aeonbits.owner.ConfigCache;
import org.sample.config.MobileConfig;

public final class MobileConfigFactory {

    private MobileConfigFactory(){}

    public static MobileConfig getConfig() {
        return ConfigCache.getOrCreate(MobileConfig.class);
    }

}
