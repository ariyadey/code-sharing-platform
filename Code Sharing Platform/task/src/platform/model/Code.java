package platform.model;

import java.time.LocalDateTime;

public class Code {
    private String code;
    private LocalDateTime updateDateTime;

    public String getCode() {
        return code;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void update(String code) {
        this.code = code;
        updateDateTime = LocalDateTime.now();
    }
}
