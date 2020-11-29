package platform.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import platform.model.Code;
import platform.util.DateTime;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.*;

@Getter
@Setter
@NoArgsConstructor
abstract class CodeDto {
    protected String code;
    protected String date;
    protected Integer time;
    protected Integer views;

    protected CodeDto(String snippet,
                      LocalDateTime uploadDateTime,
                      LocalDateTime expirationDateTime,
                      int viewsLeft) {
        this.code = snippet;
        this.date = DateTime.getFormatted(uploadDateTime);
    }

    public Code toCode() {
        final var code = new Code();
        code.setSnippet(this.code);
        code.setUploadDateTime(date == null ? now() : parse(date, DateTime.FORMATTER));
        code.setExpirationDateTime((time == null || time <= 0) ? MAX : now().plusSeconds(time));
        code.setViewsLeft((views == null || views <= 0) ? Integer.MAX_VALUE : views);
        return code;
    }
}
