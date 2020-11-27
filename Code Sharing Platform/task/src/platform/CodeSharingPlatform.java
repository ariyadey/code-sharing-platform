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
TODO: Change the hierarchy of folders according to your specifications
https://medium.com/the-resonant-web/spring-boot-2-0-project-structure-and-best-practices-part-2-7137bdcba7d3
https://www.baeldung.com/spring-data-jpa-projections
https://www.bytestree.com/spring/spring-data-jpa-projections-5-ways-return-custom-object/
https://www.baeldung.com/spring-data-rest-projections-excerpts

TODO: Use Spring's @ControllerAdvice to handle errors
https://medium.com/@jovannypcg/understanding-springs-controlleradvice-cd96a364033f
*/
