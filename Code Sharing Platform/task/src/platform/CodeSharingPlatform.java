package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@ServletComponentScan
public class CodeSharingPlatform {

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

//    public void init() {}

//    @Bean
//    public CommandLineRunner runApplication(CodeRepository repository) {
//        return args -> {};
//    }
}

/*
Todo: Change the hierarchy of folders according to your specifications
https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3

Todo: Use Spring's @ControllerAdvice to handle errors
https://medium.com/@jovannypcg/understanding-springs-controlleradvice-cd96a364033f

Todo: Use an object mapping framework (MapStruct) to facilitate mapping entities to/from projectors
https://www.baeldung.com/mapstruct

Todo: If you get rid of template engines and work just with json, then you can replace open projectors
*/
