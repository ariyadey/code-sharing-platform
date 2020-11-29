package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.dto.CodeDtoApi;
import platform.repository.CodeRepository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@RestController
public final class APIController {
    private final CodeRepository repo;

    @Autowired
    public APIController(CodeRepository repo) {
        this.repo = repo;
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private Map<String, String> postCode(@RequestBody CodeDtoApi dto) {
        return Map.of("uuid", repo.save(dto.toCode()).getId().toString());
    }

    @GetMapping(value = "/api/code/{id}")
    private CodeDtoApi getCode(@PathVariable String id) {
        return new CodeDtoApi().fromCode(repo.save(repo.findByIdAndExpirationDateTimeAfterAndViewsLeftGreaterThanOrSecretFalse(
                UUID.fromString(id),
                LocalDateTime.now(),
                0)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "There is no code with the given UUID"))));
    }

    @GetMapping(value = "/api/code/latest")
    private Collection<CodeDtoApi> getLatestCode() {
        return repo.findFirst10BySecretFalse();
    }
}
