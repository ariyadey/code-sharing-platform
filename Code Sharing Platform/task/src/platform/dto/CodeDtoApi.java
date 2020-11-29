package platform.dto;

import lombok.NoArgsConstructor;
import platform.model.Code;
import platform.util.DateTime;

import java.time.LocalDateTime;

@NoArgsConstructor
public final class CodeDtoApi extends CodeDto {

    public CodeDtoApi(Code code) {
        super(code);
        fromCode(code);
    }

    public CodeDtoApi fromCode(Code code) {
        if (code.getExpirationDateTime() == LocalDateTime.MAX) time = 0;
        else time = DateTime.getDurationLeftInSeconds(code.getExpirationDateTime());
        views = code.getViewsLeft() == Integer.MAX_VALUE ? 0 : code.getViewsLeft();
        return this;
    }
}
