package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.model.Code;
import platform.model.CodeRepo;

import java.util.List;

@RestController
public final class APIController {
    private final CodeRepo repo;

    @Autowired
    public APIController(CodeRepo repo) {
        this.repo = repo;
    }

    @GetMapping(value = "/api/code/{n}")
    private Code getCode(@PathVariable int n) { //todo does it accept int?
        return repo.getAt(n - 1);
    }

    // todo: it returns the 10 most recently uploaded codes
    @GetMapping(value = "/api/code/latest")
    private List<Code> getLatestCode() {
        return repo.getLatest(10);
    }

    //todo return in a more modern way
    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private String postCode(@RequestBody Code code) {
        repo.add(code);
        return String.format("{\"%s\": \"%d\"}", "id", repo.size());
    }
}
