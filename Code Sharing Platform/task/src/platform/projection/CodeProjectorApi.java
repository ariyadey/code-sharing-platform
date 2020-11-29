//package platform.projection;
//
//import org.springframework.beans.factory.annotation.Value;
//import platform.model.Code;
//import platform.util.DateTime;
//
//import static java.time.LocalDateTime.now;
//import static java.time.LocalDateTime.parse;
//
//public interface CodeProjectorApi {
//
//    @Value("#{target.snippet}")
//    String getCode();
//
//    @Value("#{@dateTime.getFormatted(target.uploadDateTime)}")
//    String getDate();
//
//    @Value("#{target.secret ? 0 : @dateTime.getDurationLeftInSeconds(target.expirationDateTime)}")
//    Integer getTime();
//
//    @Value("#{target.secret ? 0 : target.viewsLeft}")
//    Integer getViews();
//
//    static CodeProjectorApi fromCode(Code code) {
//        return new CodeProjectorApi() {
//
//            @Override
//            public String getCode() {
//                return code.getSnippet();
//            }
//
//            @Override
//            public String getDate() {
//                return DateTime.getFormatted(code.getUploadDateTime());
//            }
//
//            @Override
//            public Integer getTime() {
//                return code.isSecret() ? 0 : DateTime.getDurationLeftInSeconds(code.getExpirationDateTime());
//            }
//
//            @Override
//            public Integer getViews() {
//                return code.isSecret() ? 0 : code.getViewsLeft();
//            }
//        };
//    }
//
//    default Code toCode() {
//        final var code = new Code();
//        code.setSnippet(getCode());
//        code.setUploadDateTime(getDate() == null ? now() : parse(getDate(), DateTime.FORMATTER));
//        code.setSecret(getTime() > 0 || getViews() > 0);
//        code.setExpirationDateTime(getTime() > 0 ? now().plusSeconds(getTime()) : null);
//        code.setViewsLeft(getViews() > 0 ? getViews() : null);
//        return code;
//    }
//}