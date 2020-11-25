package platform.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("E, yyyy MMM dd, HH:mm:ss");

    public static String nowFormatted() {
        return LocalDateTime.now().format(FORMATTER);
    }
}
