package platform.model;

import platform.util.DateTime;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@SuppressWarnings("unused")
@Entity
public final class Code {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "VARCHAR(255)", insertable = false, updatable = false)
    private UUID id;

    private String code;

    private LocalDateTime date;

    public Code() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
