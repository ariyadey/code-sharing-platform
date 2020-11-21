package platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import platform.model.Code;
import platform.model.CodeRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class APIController {
    private final CodeRepo repo;

    @Autowired
    public APIController(CodeRepo repo) {
        this.repo = repo;
    }

    @GetMapping(value = "/api/code/{codeIndex}")
    private Code getCode(@PathVariable int codeIndex) { //todo does it accept int?
        return repo.getCodes().get(codeIndex - 1);
    }

    @GetMapping(value = "/api/code/latest")
    private List<Code> getLatestCode() {
        final var latestCodes = new ArrayList<>(repo.getCodes().subList(repo.getCodes().size() > 10 ? repo.getCodes().size() - 10 : 0, repo.getCodes().size()));
        latestCodes.sort(Comparator.comparing(Code::getDate).reversed());   //todo extract method
        return latestCodes;
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private String postCode(@RequestBody Code code) {
        code.update();
        repo.getCodes().add(code);
        //todo return in a more modern way
        return String.format("{\"%s\": \"%d\"}", "id", repo.getCodes().size());
    }
}
