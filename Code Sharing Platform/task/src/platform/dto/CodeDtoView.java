package platform.dto;

import lombok.NoArgsConstructor;
import platform.model.Code;
import platform.util.DateTime;

import java.time.LocalDateTime;

@NoArgsConstructor
public final class CodeDtoView extends CodeDto {

    public CodeDtoView(Code code) {
        super(code);
        fromCode(code);
    }

    public CodeDtoView fromCode(Code code) {
        if (code.getExpirationDateTime() == LocalDateTime.MAX) time = null;
        else time = DateTime.getDurationLeftInSeconds(code.getExpirationDateTime());
        views = code.getViewsLeft() == Integer.MAX_VALUE ? null : code.getViewsLeft();
        return this;
    }
}
