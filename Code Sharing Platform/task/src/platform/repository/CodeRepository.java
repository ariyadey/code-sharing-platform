package platform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.model.Code;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {

    Optional<Code> findByIdAndExpirationDateTimeAfterAndViewsLeftGreaterThanEqual(UUID id,
                                                                                  LocalDateTime ExpirationDatetime,
                                                                                  int viewsLeft);

    //Todo: check if it doesn't have any problem with rows less than 10
    <T> Collection<T> findFirst10ByExpirationDateTimeEqualsAndViewsLeftEqualsOrderByUploadDateTimeDesc(LocalDateTime expirationDateTime,
                                                                                                       int viewsLeft);


}
