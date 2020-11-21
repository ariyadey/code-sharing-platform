package platform.model;

import java.time.LocalDateTime;

@SuppressWarnings("unused")
public class Code {
    private String code;
    private LocalDateTime date;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //todo: manipulate it to return formatted dateTime
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    void update() {
        date = LocalDateTime.now();
    }
}
