package platform.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZoneId;

@SuppressWarnings("unused")
@Entity
public final class Code {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "SNIPPET")
    private String code;
    private LocalDateTime date;    //todo Save date in DB as Date!!!

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

    public void resetDate() {
        date = LocalDateTime.now(ZoneId.systemDefault());
    }
}
