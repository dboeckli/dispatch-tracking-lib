package dev.lydtech.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(useMainMethod = SpringBootTest.UseMainMethod.ALWAYS)
@Slf4j
public class ApplicationTest {

    public static void main(String[] args) {
        log.info("Starting Application...");
        SpringApplication.run(ApplicationTest.class, args);
    }

}
