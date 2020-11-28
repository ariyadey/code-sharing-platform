package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.projection.CodeProjectorApi;
import platform.repository.CodeRepository;
import platform.service.Service;

import java.util.Collection;
import java.util.Map;

//TODO ############ Check negativity of json attributes: time an views on all controllers #############
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
    private Map<String, String> postCode(@RequestBody CodeProjectorApi projector) {
        //Todo: Potential bug: toString() instead of String.value.of()
        return Map.of("uuid", repo.save(projector.toCode()).getId().toString());
    }

    @GetMapping(value = "/api/code/{id}")
    private CodeProjectorApi getCode(@PathVariable String id) {
        return service.projectRowById(id);
    }

    // todo: it returns the 10 most recently uploaded codes
    @GetMapping(value = "/api/code/latest")
    private Collection<CodeProjectorApi> getLatestCode() {
        return repo.findFirst10BySecretFalseOrderByUploadDateTimeDesc();
    }
}
