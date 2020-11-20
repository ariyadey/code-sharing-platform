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
todo: change the hierarchy of folders according to your specifications
todo:To get an individual snippet, you need to use GET /code/N and GET /api/code/N endpoints, where N is the code snippet number starting from 1.
todo: inverse the order of returning code objects
todo: Add DateTime Formatter
*/
