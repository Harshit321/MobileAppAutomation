package org.sample.utils.locatorutils;

import org.sample.utils.logger.LoggerUtil;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;


public final class MobilePageFactory {

    private MobilePageFactory() {
    }

    static final LoggerUtil LOGGER = new LoggerUtil(MobilePageFactory.class);

    public static MobilePage getPage(InputStream ins) {
        Constructor constructor = new Constructor(MobilePage.class, new LoaderOptions());
        TypeDescription typeDescription = new TypeDescription(MobilePage.class);
        typeDescription.addPropertyParameters("locators", String.class, Map.class);
        constructor.addTypeDescription(typeDescription);

        Yaml yamlFile = new Yaml(constructor);
        MobilePage mobilePage;
        try {
            mobilePage = yamlFile.load(new BufferedReader(
                    new InputStreamReader(ins, StandardCharsets.UTF_8)
            ));
        } finally {
            try {
                ins.close();
            } catch (IOException ex) {
                LOGGER.error("error while closing yaml file ", ex);
            }
        }
        return mobilePage;
    }


}
