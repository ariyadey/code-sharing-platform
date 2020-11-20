package platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;

import static platform.CodeSharingPlatform.CODES;

@Controller
public class ViewController {
    //    private static final String INITIAL_CODE_SNIPPET = "println(\"Hello World\")"; //todo maybe we don't need it anymore
//    private final Code code = new Code(INITIAL_CODE_SNIPPET);

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