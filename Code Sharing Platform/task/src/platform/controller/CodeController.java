package platform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import platform.model.Code;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CodeController {
    private Code code = new Code();

    @ResponseBody
    @GetMapping(value = "/api/code", consumes = "application/json")
    private Code getCode(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return code;
    }

    @GetMapping(value = "/code", produces = "text/html")
    private String getCodeHTML(HttpServletResponse response, Model model) {
        response.addHeader("Content-Type", "text/html");
        model.addAttribute("date", "for date attribute");
        model.addAttribute("code", "for code attribute");
        return "code";
    }
}
