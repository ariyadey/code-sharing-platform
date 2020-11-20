package platform.controller;

import org.springframework.web.bind.annotation.*;
import platform.model.Code;

import javax.servlet.http.HttpServletResponse;

import static platform.CodeSharingPlatform.CODES;

@RestController
public class APIController {

    @GetMapping(value = "/api/code/{codeIndex}")
    private Code getCode(HttpServletResponse response, @PathVariable int codeIndex) { //todo does it accept int?
        response.addHeader("Content-Type", "application/json");
        return CODES.get(codeIndex);
    }

    @GetMapping(value = "/api/code/latest") //todo complete method
    private Code getLatestCode(HttpServletResponse response) { //todo does it accept int?
        response.addHeader("Content-Type", "application/json");
        return CODES.get(CODES.size() - 1);
    }

    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private String postCode(@RequestBody Code code, HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        CODES.add(code);
        //todo return in a more modern way
        return String.format("{\"%s\": \"%d\"}", "id", CODES.size() - 1); //todo does it work?
    }
}
