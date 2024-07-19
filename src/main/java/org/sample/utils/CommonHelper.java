package org.sample.utils;

import java.time.Duration;

public interface CommonHelper {

     static void waitInSeconds(int seconds) {
        try {
            Thread.sleep(Duration.ofSeconds(seconds));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
