package platform.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import platform.model.Code;
import platform.projection.CodeProjectorApi;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeRepository extends CrudRepository<Code, Long> {

    //Todo: check if it doesn't have any problem with rows less than 10
    Collection<CodeProjectorApi> findFirst10BySecretFalseOrderByUploadDateTimeDesc();

    <T> Optional<T> findByIdAndViewsLeftGreaterThanEqualAndExpirationDateTimeAfter(Class<T> tClass,
                                                                                   UUID uuid,
                                                                                   int viewsLeft,
                                                                                   LocalDateTime ExpirationDatetime);
}
