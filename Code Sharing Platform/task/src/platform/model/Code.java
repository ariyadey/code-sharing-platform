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

    private boolean secret;

    private LocalDateTime date;

    private int time;

    private int views;

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

    public boolean isSecret() {
        return secret;
    }

    public void setSecret(boolean secret) {
        this.secret = secret;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getDateFormatted() {
        return DateTime.formatted(date);
    }

//    public void resetDate() {
//        date = LocalDateTime.now(ZoneId.systemDefault());
//    }
}
