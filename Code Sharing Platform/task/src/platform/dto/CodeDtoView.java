package platform.dto;

import lombok.NoArgsConstructor;
import platform.model.Code;
import platform.util.DateTime;

import java.time.LocalDateTime;

@NoArgsConstructor
public final class CodeDtoView extends CodeDto {

    public CodeDtoView(String snippet,
                       LocalDateTime uploadDateTime,
                       LocalDateTime expirationDateTime,
                       Integer viewsLeft) {
        fromCode(new Code(snippet, uploadDateTime, expirationDateTime, viewsLeft));
    }

    public CodeDtoView fromCode(Code code) {
        super.fromCode(code);
        if (code.getExpirationDateTime() == null) time = null;
        else time = DateTime.getDurationLeftInSeconds(code.getExpirationDateTime());
        views = code.getViewsLeft() == null ? null : code.getViewsLeft();
        return this;
    }
}
