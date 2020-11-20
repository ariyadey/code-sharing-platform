package platform.controller;

import org.springframework.web.bind.annotation.*;
import platform.model.Code;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static platform.CodeSharingPlatform.CODES;

@RestController
public class APIController {

    @GetMapping(value = "/api/code/{codeIndex}")
    private Code getCode(@PathVariable int codeIndex) { //todo does it accept int?
        return CODES.get(codeIndex - 1);
    }

    @GetMapping(value = "/api/code/latest")
    private List<Code> getLatestCode() {
        final var latestCodes = new ArrayList<>(CODES.subList(CODES.size() > 10 ? CODES.size() - 10 : 0, CODES.size()));
        latestCodes.sort(Comparator.comparing(Code::getDate).reversed());   //todo extract method
        return latestCodes;
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private String postCode(@RequestBody Code code) {
        code.update();
        CODES.add(code);
        //todo return in a more modern way
        return String.format("{\"%s\": \"%d\"}", "id", CODES.size());
    }
}
