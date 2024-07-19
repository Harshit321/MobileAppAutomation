package org.sample.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class DateHelper {

    private DateHelper() {
    }

    private final static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
    private static Date date;

    public static String getCurrentTimeAsString() {
        date = Calendar.getInstance().getTime();
        return dateFormat.format(date).replace(" ", "_");
    }

}
