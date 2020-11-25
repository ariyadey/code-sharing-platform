package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import platform.model.Code;
import platform.model.CodeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public final class APIController {
    private final CodeRepository repo;

    @Autowired
    public APIController(CodeRepository repo) {
        this.repo = repo;
    }

    //todo return type Long or String???
    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private long postCode(@RequestBody Code code) {
        code.resetDate();
        return repo.save(code).getId();
    }

    //todo get rid of Map
    @GetMapping(value = "/api/code/{id}")
    private Map<String, String> getCode(@PathVariable long id) {
        final var code = repo.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no code with the given ID"));
        return Map.of(
                "code", code.getCode(),
                "date", code.getDate()
        );
    }

    //todo get rid of map
    // todo: it returns the 10 most recently uploaded codes
    @GetMapping(value = "/api/code/latest")
    private List<Map<String, String>> getLatestCode() {
        var codeMapList = new ArrayList<Map<String, String>>();
        final var codes = repo.findAllOrderByDateDesc().subList(0, 9);
        for (var code : codes) {
            codeMapList.add(Map.of(
                    "code", code.getCode(),
                    "date", code.getDate()
            ));
        }
        return codeMapList;
    }
}
