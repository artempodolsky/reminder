package ru.management.reminder.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class DateUtil {

    private static final DateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);

    public static Timestamp isoToTimestamp(String dateTime) {
        try {
            return new Timestamp(FORMAT.parse(dateTime).getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String timestampToIso(Timestamp timestamp) {
        return FORMAT.format(timestamp);
    }

}
