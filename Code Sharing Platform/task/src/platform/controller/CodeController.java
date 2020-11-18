package platform.controller;

import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletResponse;

public class CodeController {
    private static final class Code {
        private final String code;

        private Code() {
            code = "public static void main(String[] args) {\n" +
                   "    SpringApplication.run(CodeSharingPlatform.class, args);";
        }

        public String getCode() {
            return code;
        }
    }

    private static final Code CODE = new Code();

    @GetMapping("/code")
    private String getCodeHTML(HttpServletResponse response) {
        response.addHeader("Content-Type", "text/html");
        return "<!DOCTYPE html>" +
               "<html>\n" +
               "    <head>\n" +
               "        <meta charset=utf-8>" +
               "        <title>Code</title>\n" +
               "    </head>\n" +
               "    <body>\n" +
               "        <pre>\n" +
               CODE.getCode() +
               "</pre>\n" +
               "    </body>\n" +
               "</html>";
    }

    @GetMapping("/api/code")
    private Code getCodeAPI(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return CODE;
    }
}
