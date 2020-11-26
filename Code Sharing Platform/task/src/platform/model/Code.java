package platform.model;

import platform.util.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


@SuppressWarnings("unused")
@Entity
public final class Code {

    @Id
    @GeneratedValue
    private long id;

    private String code;

    private LocalDateTime date;

    public Code() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getDateFormatted() {
        return DateTime.formatted(date);
    }

//    public void resetDate() {
//        date = LocalDateTime.now(ZoneId.systemDefault());
//    }
}
