package platform.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.model.Code;

import javax.servlet.http.HttpServletResponse;

@RestController
public class CodeController {
    private final Code code = new Code();

    @GetMapping("/api/code")
    private Code getCodeAPI(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return code;
    }

    @GetMapping("/code")
    private String getCodeHTML( HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        return "<!DOCTYPE html>" +
               "<html>\n" +
               "    <head>\n" +
               "        <meta charset=utf-8>" +
               "        <title>Code</title>\n" +
               "    </head>\n" +
               "    <body>\n" +
               "        <pre>\n" +
               code.getCode() +
               "</pre>\n" +
               "    </body>\n" +
               "</html>";
    }
}
