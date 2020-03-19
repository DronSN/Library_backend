package ru.relex.library.db;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({
        "ru.relex.library.db.mappers",
})
public class DataConfiguration {
}
