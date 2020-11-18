package platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import platform.model.Code;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CodeController {
    private final Code code = new Code();

    @ResponseBody
    @GetMapping("/api/code")
    private Code getCodeAPI(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return code;
    }

    @GetMapping("/code")
    private String getCodeHTML(HttpServletResponse response, Model model) {
        response.addHeader("Content-Type", "text/html");
        model.addAttribute("code", code.getCode());
        return "code";

    }
}
