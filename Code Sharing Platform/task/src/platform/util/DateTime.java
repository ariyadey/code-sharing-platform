package platform.util;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public interface DateTime {
    DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("E, yyyy MMM dd, HH:mm:ss");

    static String getFormatted(LocalDateTime dateTime) {
        return dateTime.format(FORMATTER);
    }

    static int getDurationLeftInSeconds(LocalDateTime dateTime) {
        return Math.max(Duration.between(dateTime, LocalDateTime.now()).toSecondsPart(), 0);
    }
}
