package platform.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import platform.model.Code;
import platform.util.DateTime;

import static java.time.LocalDateTime.now;
import static java.time.LocalDateTime.parse;

@Getter
@Setter
@NoArgsConstructor
abstract class CodeDto {
    protected String code;
    protected String date;
    protected Integer time;
    protected Integer views;

    protected CodeDto(Code code) {
        fromCode(code);
    }

    protected CodeDto fromCode(Code code) {
        this.code = code.getSnippet();
        date = DateTime.getFormatted(code.getUploadDateTime());
        return this;
    }

    public Code toCode() {
        final var code = new Code();
        code.setSnippet(this.code);
        code.setUploadDateTime(date == null ? now() : parse(date, DateTime.FORMATTER));
        code.setSecret(time > 0 || views > 0);
        code.setExpirationDateTime((time == null || time <= 0) ? null : now().plusSeconds(time));
        code.setViewsLeft((views == null || views <= 0) ? null : views);
        return code;
    }
}
