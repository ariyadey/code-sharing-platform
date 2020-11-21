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

    public LocalDateTime getDate() {
        return date;
    }   //todo: manipulate it to return formatted dateTime

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void update() {
        date = LocalDateTime.now();
    }
}
