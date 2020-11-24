package platform;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import platform.model.CodeRepository;


@SpringBootApplication
//@ServletComponentScan
public class CodeSharingPlatform {

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @Bean
    public CommandLineRunner runApplication(CodeRepository repository) {
        return args -> {
            
        };
    }
}

/*
todo: change the hierarchy of folders according to your specifications and mvc
todo: format the output dateTime
*/
