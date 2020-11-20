package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.model.Code;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CodeSharingPlatform {
    public static final List<Code> CODES = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }
}

//todo: add IoC
//todo: Use Filter to omit duplicated code for HTTP headers (Link in first or second stage)
//todo: change the hierarchy of folders according to your specifications