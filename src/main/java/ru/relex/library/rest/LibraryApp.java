package ru.relex.library.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.relex.library.db.DataConfiguration;

@SpringBootApplication(
        scanBasePackages = "ru.relex.library.rest"
)
@Import(DataConfiguration.class)
public class LibraryApp {
    public static void main(String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }
}

