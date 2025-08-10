package io.github.happy1claire.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

/**
 * The main entry point for the Diary Spring Boot application.
 */
@SpringBootApplication
@ConfigurationPropertiesScan("io.github.happy1claire.diary.config")
public class DiaryApp {
    public static void main(String[] args) {
        SpringApplication.run(DiaryApp.class, args);
    }
}
