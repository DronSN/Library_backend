package ru.relex.library.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import ru.relex.library.security.SecurityConfig;
import ru.relex.library.services.ServicesConfig;

@SpringBootApplication(
        scanBasePackages = "ru.relex.library.rest"
)
@Import({
        ServicesConfig.class,
        SecurityConfig.class
})
public class LibraryApp {

    public static void main(String[] args) {
        SpringApplication.run(LibraryApp.class, args);
    }
}
