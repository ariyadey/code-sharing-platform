package platform.dto;

import lombok.NoArgsConstructor;
import platform.model.Code;
import platform.util.DateTime;

import java.time.LocalDateTime;

@NoArgsConstructor
public final class CodeDtoApi extends CodeDto {

    public CodeDtoApi(String snippet,
                      LocalDateTime uploadDateTime,
                      LocalDateTime expirationDateTime,
                      Integer viewsLeft) {
        fromCode(new Code(snippet, uploadDateTime, expirationDateTime, viewsLeft));
    }

    public CodeDtoApi fromCode(Code code) {
        super.fromCode(code);
        if (code.getExpirationDateTime() == null) time = 0;
        else time = DateTime.getDurationLeftInSeconds(code.getExpirationDateTime());
        views = code.getViewsLeft() == null ? 0 : code.getViewsLeft();
        return this;
    }
}
