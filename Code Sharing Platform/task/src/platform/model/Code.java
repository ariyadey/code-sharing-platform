package platform.model;

import platform.utils.DateTime;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public final class Code {
    private String code;
    private String date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    void update() {
        date = DateTime.format(LocalDateTime.now());
    }
}
