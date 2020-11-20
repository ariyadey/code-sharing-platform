package platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import platform.model.Code;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CodeController {
    private static final String INITIAL_CODE_SNIPPET = "println(\"Hello World\")";
    private final CodeRepository codeRepository = new CodeRepository(INITIAL_CODE_SNIPPET);

    @ResponseBody
    @GetMapping(value = "/api/code")
    private CodeRepository getCode(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return codeRepository;
    }

    @ResponseBody
    @PostMapping(value = "/api/code/new", consumes = "application/json")
    private String postCode(@RequestBody CodeRepository codeRepository, HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        this.codeRepository.update(codeRepository.getCode());
        return "{}";
    }

    @GetMapping(value = "/code")
    private String getCodeView(HttpServletResponse response, Model model) {
        response.addHeader("Content-Type", "text/html");
        model.addAttribute("date", codeRepository.getDate());
        model.addAttribute("code", codeRepository.getCode());
        return "code";
    }

    @GetMapping("/code/new")
    private String getNewCodeView(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        return "new";
    }
}
