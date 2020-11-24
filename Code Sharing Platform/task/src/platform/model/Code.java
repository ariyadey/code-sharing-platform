package platform.model;

import platform.utils.DateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@SuppressWarnings("unused")
@Entity
public final class Code {
    @Id
    private Integer id;
    private String code;
    private String date;

    public Code() {
    }

    public Integer getId() {
        return id;
    }

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

    public void setId(Integer id) {
        this.id = id;
    }

    void update() {
        date = DateTime.format(LocalDateTime.now());
    }
}
