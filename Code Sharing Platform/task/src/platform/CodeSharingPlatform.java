package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {

    final String code = "public static void main(String[] args) {\n" +
                        "    SpringApplication.run(CodeSharingPlatform.class, args);";

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

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
               code +
               "</pre>\n" +
               "    </body>\n" +
               "</html>";
    }

    @GetMapping("/api/code")
    private String getCodeAPI(HttpServletResponse response) {
        response.addHeader("Content-Type", "application/json");
        return code;
    }
}
