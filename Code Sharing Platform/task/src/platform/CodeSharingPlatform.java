package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import platform.model.Code;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@ServletComponentScan
public class CodeSharingPlatform {
    public static final List<Code> CODES = new ArrayList<>();   //todo think about this pain in the ass!!!

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }
}

/*
todo: add IoC
todo: change the hierarchy of folders according to your specifications and mvc
*/
