package com.example.pwt_lab7;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookModel,Long> {
    Optional<BookModel> findByName(String name);
    Optional<BookModel> findByAuthor(String author);
    Optional<BookModel> findByPages(Integer pages);
    Optional<BookModel> findByNameAndAuthor (String name, String author);
    Optional<BookModel> findByPublisherAndPublishYear(String publisher, Integer year);
    Optional<BookModel> findByPublishYear(Integer year);
    Optional<BookModel> findByGenreAndAuthorAndPublishYear(String genre, String author, Integer year);
    Optional<BookModel> findByDescriptionContaining(String description);
}
