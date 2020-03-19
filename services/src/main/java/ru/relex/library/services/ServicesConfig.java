package ru.relex.library.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.relex.library.db.DataConfiguration;

@Configuration
@ComponentScan({
    "ru.relex.library.services.mapstruct",
    "ru.relex.library.services.service"
})
@Import(DataConfiguration.class)
public class ServicesConfig {
}
