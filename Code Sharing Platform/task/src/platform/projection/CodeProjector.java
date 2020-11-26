package platform.projection;

import platform.util.DateTime;

import java.time.LocalDateTime;

public class CodeProjector {
//    String getDateFormatted(LocalDateTime dateTime) {
//        return DateTime.Formatted(dateTime);
//    }

    private final String code;
    private final LocalDateTime date;

    public CodeProjector(String code, LocalDateTime date) {
        this.code = code;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return DateTime.formatted(date);
    }
}
