package platform.projection;

import org.springframework.beans.factory.annotation.Value;

public interface CodeProjection {

    @Value("#{target.snippet}")
    String getCode();

    @Value("#{@projectionHelper.getUploadDateTimeFormatted(target)}")
    String getDate();

    @Value("#{@projectionHelper.getSecondsLeft(target)}")
    int getTime();

    @Value("#{target.viewsLeft}")
    int getViews();

}
