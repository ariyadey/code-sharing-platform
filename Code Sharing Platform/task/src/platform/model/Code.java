package platform.model;

import platform.utils.DateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@SuppressWarnings("unused")
@Entity
public final class Code {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "SNIPPET")
    private String code;
    private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void resetDate() {
        date = DateTime.nowFormatted();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
