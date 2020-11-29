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

    //Todo: refactor it
    public Code viewCodeById(String id) {
        final var optCode = repo.findById(UUID.fromString(id));
        if (optCode.isPresent()) {
            final var code = optCode.orElseThrow();
            if (code.getExpirationDateTime() == null || (code.getExpirationDateTime().isAfter(LocalDateTime.now()))) {
                if (code.getViewsLeft() != null && code.getViewsLeft() > 0) {
                    code.setViewsLeft(code.getViewsLeft() - 1);
                    return repo.save(code);
                } else if (code.getViewsLeft() == null)
                    return repo.save(code);
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no code with the given UUID");
    }
}
