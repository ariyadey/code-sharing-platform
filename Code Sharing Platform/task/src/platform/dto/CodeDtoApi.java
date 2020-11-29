package platform.dto;

import lombok.NoArgsConstructor;
import platform.model.Code;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.MAX;
import static platform.util.DateTime.getDurationLeftInSeconds;
import static platform.util.DateTime.getFormatted;

@NoArgsConstructor
public final class CodeDtoApi extends CodeDto {

    //Todo: Add the hole code as parameter not the fields and test it
    public CodeDtoApi(String snippet,
                      LocalDateTime uploadDateTime,
                      LocalDateTime expirationDateTime,
                      int viewsLeft) {
        super(snippet, uploadDateTime, expirationDateTime, viewsLeft);
        time = expirationDateTime == MAX ? null : getDurationLeftInSeconds(expirationDateTime);
        views = viewsLeft == Integer.MAX_VALUE ? null : viewsLeft;
    }

    public static CodeDtoApi fromCode(Code code) {
        final var codeDtoApi = new CodeDtoApi();
        codeDtoApi.setCode(code.getSnippet());
        codeDtoApi.setDate(getFormatted(code.getUploadDateTime()));
        codeDtoApi.setTime(code.getExpirationDateTime() == MAX ? 0 : getDurationLeftInSeconds(code.getExpirationDateTime()));
        codeDtoApi.setViews(code.getViewsLeft() == Integer.MAX_VALUE ? 0 : code.getViewsLeft());
        return codeDtoApi;
    }
}
