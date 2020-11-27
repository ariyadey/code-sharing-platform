package platform.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    private DateTime() {}

    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("E, yyyy MMM dd, HH:mm:ss");

    public static String formatted(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }
}
