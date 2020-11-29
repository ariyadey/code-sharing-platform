package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.dto.CodeDtoApi;
import platform.repository.CodeRepository;
import platform.service.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

//TODO ############ Check negativity of json attributes: time an views on all controllers #############
@RestController
public final class APIController {
    private final CodeRepository repo;
//    private final Service service;

    @Autowired
    public APIController(CodeRepository repo, Service service) {
        this.repo = repo;
//        this.service = service;
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private Map<String, String> postCode(@RequestBody CodeDtoApi dto) {
        return Map.of("uuid", repo.save(dto.toCode()).getId().toString());
    }

    @GetMapping(value = "/api/code/{id}")
    private CodeDtoApi getCode(@PathVariable String id) {
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

    //Todo: it returns the 10 most recently uploaded codes
//    @GetMapping(value = "/api/code/latest")
//    private Collection<CodeProjectorApi> getLatestCode() {
//        return repo.findFirst10BySecretFalseOrderByUploadDateTimeDesc();
//    }
}
