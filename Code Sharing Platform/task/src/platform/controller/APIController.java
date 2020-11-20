package platform.controller;

import org.springframework.web.bind.annotation.*;
import platform.model.Code;

import java.util.List;

import static platform.CodeSharingPlatform.CODES;

@RestController
public class APIController {

    @GetMapping(value = "/api/code/{codeIndex}")
    private Code getCode(@PathVariable int codeIndex) { //todo does it accept int?
        return CODES.get(codeIndex);
    }

    @GetMapping(value = "/api/code/latest")
    private List<Code> getLatestCode() {
        return CODES.subList(CODES.size() - 10, CODES.size());
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private String postCode(@RequestBody Code code) {
        CODES.add(code);
        //todo return in a more modern way
        return String.format("{\"%s\": \"%d\"}", "id", CODES.size() - 1); //todo does it work?
    }
}
