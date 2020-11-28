package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import platform.model.Code;
import platform.projection.CodeProjectorApi;
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

    public CodeProjectorApi projectRowById(String id) {
        final var code = repo.findByIdAndViewsLeftGreaterThanEqualAndExpirationDateTimeAfter(
                Code.class,
                UUID.fromString(id),
                -1,
                LocalDateTime.now())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no code with the given UUID"));
        if (code.isSecret()) {
            code.setViewsLeft(code.getViewsLeft() - 1);
            return CodeProjectorApi.fromCode(repo.save(code));
        }
        return CodeProjectorApi.fromCode(code);
    }
}
