package org.sample.utils.fileUtils;

import org.sample.utils.logger.LoggerUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class FileUtils {

    static final LoggerUtil LOGGER = new LoggerUtil(FileUtils.class);

    private FileUtils() {
    }

    public static InputStream loadFile(String fileName) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream istream = loader.getResourceAsStream(fileName);
        if (istream == null) {
            try {
                istream = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                LOGGER.error("Exception", e);
            }
        }
        if (istream == null) {
            throw new IllegalArgumentException("[" + fileName + "] is not a valid resource");
        }
        return istream;
    }

}
