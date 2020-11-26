package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ServletComponentScan
public class CodeSharingPlatform {

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

//    @Bean
//    public CommandLineRunner runApplication(CodeRepository repository) {
//        return args -> {};
//    }
}

/*
todo: change the hierarchy of folders according to your specifications and mvc
todo: Make controllers return formatted date
todo: Highlight the code snippet based on the guidance
todo: Use Spring's @ControllerAdvice to handle errors
*/
