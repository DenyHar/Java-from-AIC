package com.example.pwt_lab7;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
            var bookList = List.of(
                    new BookModel(null,
                            "Книга Перша",
                            "Автор 1",
                            2021,
                            "Видавництво 1",
                            "Романтика",
                            128,
                            "Романтична історія",
                            10000
                    ),

                    new BookModel(null,
                            "Книга Друга",
                            "Автор 2",
                            2023,
                            "Видавництво 2",
                            "Фентезі",
                            512,
                            "Мечі, магія, дракони",
                            30000
                    )
            );
            bookRepository.saveAll(bookList);

        };
    }
}
