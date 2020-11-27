//Todo: Consider adding a boolean field named expired to optimize the code

package platform.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import platform.projection.CodeProjection;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;


@SuppressWarnings("unused")
@Entity
@NoArgsConstructor
@Getter
@Setter
public final class Code {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "VARCHAR(255)", insertable = false, updatable = false)
    @Id
    private UUID id;

    @Column
    private String snippet;

    @Column
    private boolean secret;

    @Column
    private LocalDateTime uploadDateTime;

    @Column
    private LocalDateTime expirationDateTime;

    @Column
    private int viewsLeft;

    private Code(String snippet, int secondsLeft, int viewsLeft) {
        this.snippet = snippet;
        this.secret = secondsLeft > 0 || viewsLeft > 0;
        this.uploadDateTime = LocalDateTime.now();
        this.expirationDateTime = LocalDateTime.now().plusSeconds(secondsLeft);
        this.viewsLeft = viewsLeft;
    }

    public static Code mapFrom(CodeProjection projection) {
        return new Code(projection.getCode(), projection.getTime(), projection.getViews());
    }

//    public Code() {
//    }
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public boolean isSecret() {
//        return secret;
//    }
//
//    public void setSecret(boolean secret) {
//        this.secret = secret;
//    }
//
//    public LocalDateTime getUploadDateTime() {
//        return uploadDateTime;
//    }
//
//    public void setUploadDateTime(LocalDateTime uploadDateTime) {
//        this.uploadDateTime = uploadDateTime;
//    }
//
//    public LocalDateTime getExpirationDateTime() {
//        return expirationDateTime;
//    }
//
//    public void setExpirationDateTime(LocalDateTime expirationDateTime) {
//        this.expirationDateTime = expirationDateTime;
//    }
//
//    public int getRemainedViews() {
//        return remainedViews;
//    }
//
//    public void setRemainedViews(int remainedViews) {
//        this.remainedViews = remainedViews;
//    }


}
