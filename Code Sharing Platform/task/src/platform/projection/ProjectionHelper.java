package platform.projection;

import org.springframework.stereotype.Component;
import platform.model.Code;
import platform.util.DateTime;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ProjectionHelper {

    public String getUploadDateTimeFormatted(Code code) {
        return DateTime.formatted(code.getUploadDateTime());
    }

    public int getSecondsLeft(Code code) {
        return Math.max(Duration.between(code.getExpirationDateTime(), LocalDateTime.now()).toSecondsPart(), 0);
    }
}
