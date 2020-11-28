//Todo: Consider adding a boolean field named expired to optimize the code

package platform.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
public final class Code {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "VARCHAR(255)", insertable = false, updatable = false)
    @Id
    private UUID id;

    @Column(nullable = false, updatable = false)
    private String snippet;

    @Column(nullable = false, updatable = false)
    private LocalDateTime uploadDateTime;

    @Column(nullable = false, updatable = false)
    private boolean secret;

    @Column(updatable = false)
    private LocalDateTime expirationDateTime;

    @Column
    private Integer viewsLeft;
}
