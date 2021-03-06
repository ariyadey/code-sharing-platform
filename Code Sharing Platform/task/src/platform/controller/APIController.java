package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.dto.CodeDtoApi;
import platform.repository.CodeRepository;
import platform.service.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@RestController
public final class APIController {
    private final CodeRepository repo;
    private final Service service;

    @Autowired
    public APIController(CodeRepository repo, Service service) {
        this.repo = repo;
        this.service = service;
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private Map<String, String> postCode(@RequestBody CodeDtoApi dto) {
        return Map.of("id", repo.save(dto.toCode()).getId().toString());
    }

    @GetMapping(value = "/api/code/{id}")
    private CodeDtoApi getCode(@PathVariable String id) {
        return new CodeDtoApi().fromCode(service.viewCodeById(id));
    }

    @GetMapping(value = "/api/code/latest")
    private Collection<CodeDtoApi> getLatestCode() {
        final var codes = repo.findFirst10BySecretFalseOrderByUploadDateTimeDesc();
        final Collection<CodeDtoApi> dtoCollection = new ArrayList<>();
        for (var code : codes) dtoCollection.add(new CodeDtoApi().fromCode(code));
        return dtoCollection;
    }
}
