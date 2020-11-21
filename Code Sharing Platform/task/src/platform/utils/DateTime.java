package platform.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("E, yyyy MMM dd, HH:mm:ss");

    public static String format(LocalDateTime localDateTime) {
        return localDateTime.format(FORMATTER);
    }
}
