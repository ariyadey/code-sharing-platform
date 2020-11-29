package platform.dto;

import lombok.NoArgsConstructor;
import platform.model.Code;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.MAX;
import static platform.util.DateTime.getDurationLeftInSeconds;
import static platform.util.DateTime.getFormatted;

@NoArgsConstructor
public final class CodeDtoView extends CodeDto {

    //Todo: Add the hole code as parameter not the fields and test it
    public CodeDtoView(String snippet,
                       LocalDateTime uploadDateTime,
                       LocalDateTime expirationDateTime,
                       int viewsLeft) {
        super(snippet, uploadDateTime, expirationDateTime, viewsLeft);
        time = expirationDateTime == MAX ? 0 : getDurationLeftInSeconds(expirationDateTime);
        views = viewsLeft == Integer.MAX_VALUE ? 0 : viewsLeft;
    }

    public static CodeDtoView fromCode(Code code) {
        final var codeDtoView = new CodeDtoView();
        codeDtoView.setCode(code.getSnippet());
        codeDtoView.setDate(getFormatted(code.getUploadDateTime()));
        codeDtoView.setTime(code.getExpirationDateTime() == MAX ? null : getDurationLeftInSeconds(code.getExpirationDateTime()));
        codeDtoView.setViews(code.getViewsLeft() == Integer.MAX_VALUE ? null : code.getViewsLeft());
        return codeDtoView;
    }
}
