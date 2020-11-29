package platform.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public interface DateTime {
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("E, yyyy MMM dd, HH:mm:ss");

    static String getFormatted(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }

    static int getDurationLeftInSeconds(LocalDateTime dateTime) {
        return Math.toIntExact(Math.max(Duration.between(LocalDateTime.now(), dateTime).toSeconds(), 0));
    }
}
