package platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import platform.model.Code;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CodeController {
    //    private static final String INITIAL_CODE_SNIPPET = "println(\"Hello World\")"; //todo maybe we don't need it anymore
//    private final Code code = new Code(INITIAL_CODE_SNIPPET);
    private static final List<Code> CODES = new ArrayList<>();

    @ResponseBody
    @GetMapping(value = "/api/code/{codeIndex}")
    private Code getCode(HttpServletResponse response, @PathVariable int codeIndex) { //todo does it accept int?
        response.addHeader("Content-Type", "application/json");
        return CODES.get(codeIndex);
    }

    @ResponseBody
    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private String postCode(@RequestBody Code code, HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        CODES.add(code);
        return String.format("{\"%s\": \"%d\"}", "id", CODES.size() - 1); //todo does it work?
    }

    @GetMapping(value = "/code/{codeNumber}")   //todo does it accept int?
    private String getCodeView(HttpServletResponse response, Model model, @PathVariable int codeNumber) {
        response.addHeader("Content-Type", "text/html");
        model.addAttribute("date", CODES.get(codeNumber).getDate());
        model.addAttribute("code", CODES.get(codeNumber).getCode());
        return "code";
    }

    @GetMapping("/code/new")
    private String getNewCodeView(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        return "new";
    }
}
