package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeSharingPlatform {
    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }
}

//todo: add IoC
//todo: Use Filter to omit duplicated code for HTTP headers (Link in first or second stage)
//todo: split controllers from REST controllers
//todo: change the hierarchy of folders according to your specifications