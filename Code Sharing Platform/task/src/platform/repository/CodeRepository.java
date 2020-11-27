package platform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.model.Code;
import platform.projection.CodeProjection;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {

    //Todo: check if it doesn't have any problem with rows less than 10
    List<CodeProjection> findFirst10BySecretFalseOrderByUploadDateTimeDesc();

    Optional<CodeProjection> findByIdAndViewsLeftGreaterThanAndExpirationDateTimeAfter(UUID uuid,
                                                                                       int viewsLeft,
                                                                                       LocalDateTime ExpirationDatetime);
}
