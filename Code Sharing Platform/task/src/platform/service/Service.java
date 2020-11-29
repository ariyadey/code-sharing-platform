package platform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import platform.model.Code;
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

    public Code viewCodeById(String id) {
        final var code = repo.findByIdAndExpirationDateTimeAfterAndViewsLeftGreaterThanOrSecretFalse(
                UUID.fromString(id),
                LocalDateTime.now(),
                0)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "There is no code with the given UUID"));
        code.setViewsLeft(code.getViewsLeft() - 1);
        return repo.save(code);
    }
}
