package dev.toode.reading;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ReadingConfig {

    @Bean
    CommandLineRunner commandLineRunner(ReadingRepository readingRepository) {
        return args -> {
            Reading defaultReading1 = new Reading(4, 1588680000000L, 35);
            Reading defaultReading2 = new Reading(3, 1588680000000L, 45);
            readingRepository.saveAll(List.of(defaultReading1, defaultReading2));
        };
    }
}
