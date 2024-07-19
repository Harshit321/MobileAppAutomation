package org.sample.utils.logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sample.config.factory.MobileConfigFactory;

public class LoggerUtil {

    private static final String givenLogLevel = MobileConfigFactory.getConfig().logLevel();

    private final Logger LOGGER;
    private final Level logLevel;

    public <T> LoggerUtil(Class<T> className) {
        LOGGER = LogManager.getLogger(className);
        if (givenLogLevel == null || givenLogLevel.isEmpty()) {
            logLevel = Level.INFO;
        } else {
            switch (givenLogLevel.toUpperCase()) {
                case "TRACE":
                    logLevel = Level.TRACE;
                    break;
                case "DEBUG":
                    logLevel = Level.DEBUG;
                    break;
                case "WARN":
                    logLevel = Level.WARN;
                    break;
                case "FATAL":
                    logLevel = Level.FATAL;
                    break;
                case "ERROR":
                    logLevel = Level.ERROR;
                    break;
                default:
                    logLevel = Level.INFO;
            }
        }
    }

    public void trace(String message) {
        LOGGER.trace(message);
    }

    public void debug(String message) {
        if ((logLevel.equals(Level.TRACE)) || (logLevel.equals(Level.DEBUG))) {
            LOGGER.debug(message);
        }
    }

    public void info(String message) {
        if ((logLevel.equals(Level.TRACE))
                || (logLevel.equals(Level.DEBUG))
                || (logLevel.equals(Level.INFO))) {
            LOGGER.info(message);
        }
    }

    public void warn(String message) {
        if ((logLevel.equals(Level.TRACE))
                || (logLevel.equals(Level.DEBUG))
                || (logLevel.equals(Level.INFO))) {
            LOGGER.warn(message);
        }
    }

    public void error(String message) {
        if ((logLevel.equals(Level.TRACE))
                || (logLevel.equals(Level.DEBUG))
                || (logLevel.equals(Level.WARN))) {
            LOGGER.error(message);
        }
    }

    public void fail(String message) {
        LOGGER.error(message);
    }

    public void error(String message, Exception e) {
        LOGGER.error(message, e);
    }

    public void fatal(String message) {
        LOGGER.fatal(message);
    }

}
