package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import platform.dto.CodeDtoApi;
import platform.repository.CodeRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@org.springframework.stereotype.Service
public class Service {
    private final CodeRepository repo;

    @Autowired
    public Service(CodeRepository repo) {
        this.repo = repo;
    }

    public CodeDtoApi viewCodeById(String id) {
        //Todo: check if the view field changes properly
        return CodeDtoApi.fromCode(repo.save(repo.findByIdAndExpirationDateTimeAfterAndViewsLeftGreaterThanEqual(
                UUID.fromString(id),
                LocalDateTime.now(),
                0)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "There is no code with the given UUID"))));
    }

//    public Optional<CodeDtoApi> viewCodeById(Class<T> tClass, String id) {
//        final var optional = repo.findByIdAndExpirationDateTimeAfterAndViewsLeftGreaterThanEqual(
//                CodeDtoApi.class,
//                UUID.fromString(id),
//                LocalDateTime.now(),
//                0);
//    }
}
