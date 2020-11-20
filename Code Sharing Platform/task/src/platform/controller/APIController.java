package platform.controller;

import org.springframework.web.bind.annotation.*;
import platform.model.Code;

import static platform.CodeSharingPlatform.CODES;

@RestController
public class APIController {

    @GetMapping(value = "/api/code/{codeIndex}")
    private Code getCode(@PathVariable int codeIndex) { //todo does it accept int?
        return CODES.get(codeIndex);
    }

    @GetMapping(value = "/api/code/latest") //todo complete method
    private Code getLatestCode() { //todo does it accept int?
        return CODES.get(CODES.size() - 1);
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private String postCode(@RequestBody Code code) {
        CODES.add(code);
        //todo return in a more modern way
        return String.format("{\"%s\": \"%d\"}", "id", CODES.size() - 1); //todo does it work?
    }
}
