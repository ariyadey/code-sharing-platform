package platform.model;

import java.time.LocalDateTime;

public class CodeRepository {
    private String code;
    private LocalDateTime date;

    public String getCode() {
        return code;
    }

    public CodeRepository(String code) {
        this.code = code;
        date = LocalDateTime.now();
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

    public void update(String code) {
        this.code = code;
        date = LocalDateTime.now();
    }
}
