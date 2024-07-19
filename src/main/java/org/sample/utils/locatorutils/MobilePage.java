package org.sample.utils.locatorutils;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.sample.config.factory.MobileConfigFactory;
import org.sample.utils.logger.LoggerUtil;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MobilePage {

    static final LoggerUtil LOGGER = new LoggerUtil(MobilePage.class);

    private Map<String, Map<String, Map<String, String>>> elements = new ConcurrentHashMap<>();

    @Getter
    @Setter
    private Map<String, Map<String, Map<String, String>>> locators = new ConcurrentHashMap<>();

    @Getter
    @Setter
    private String defaultClient = "android";


    public Map getLocator(String... keys) {
        if (keys.length == 0) {
            throw new RuntimeException("locator can not be null");
        }
        String key = keys[0];
        if (!locators.containsKey(key))
            LOGGER.error("locators is missing on the page " + key);

        Map<String, Map<String, String>> locatorsMap = locators.get(key);

        String client = MobileConfigFactory.getConfig().platform().toString().toLowerCase();

        if (StringUtils.isBlank(client)) {
            client = defaultClient;
        }

        return fetchLocatorFromMap(locatorsMap, client, keys);
    }


    private Map<String, String> fetchLocatorFromMap(Map<String, Map<String, String>> locatorMap,
                                                    String client, String... keys) {
        Map<String, String> locator = new HashMap<>(locatorMap.get(client));
        if (keys.length > 1) {
            locator.put("value", MessageFormat.format(locator.get("value"),
                    Arrays.copyOfRange(keys, 1, keys.length)));
        }
        return locator;
    }


}
