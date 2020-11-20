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
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Code() {
    }

    public Code(String code) {
        this.code = code;
        date = LocalDateTime.now();
    }

    public void update(String code) {
        this.code = code;
        date = LocalDateTime.now();
    }
}
