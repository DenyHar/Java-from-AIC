package com.example.pwt_lab7;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    private final  BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public BookModel createBook(@RequestBody BookModel bookModel) {
        return bookService.createBook(bookModel);
    }

    @GetMapping
    public List<BookModel> findAll() {
        return bookService.findAll();
    }

    @PutMapping("/{bookId}")
    public void updateBook(@PathVariable("bookId") Long bookId,
                                @RequestBody BookModel bookModel) {
        bookService.updateBook(bookId, bookModel);
    }
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }
    @GetMapping("/name={name}")
    public Optional<BookModel> getByName(@PathVariable("name") String name) {
        return bookService.findByName(name);
    }
    @GetMapping("/author={author}")
    public Optional<BookModel> getByAuthor(@PathVariable("author") String author) {
        return bookService.findByAuthor(author);
    }
    @GetMapping("/pages={pages}")
    public Optional<BookModel> findByPages(@PathVariable("pages") Integer pages) {
        return bookService.findByPages(pages);
    }
    @GetMapping({"/name={name}/author={author}", "/author={author}/name={name}"})
    public Optional<BookModel> findByNameAndAuthor(@PathVariable("name") String name, @PathVariable("author") String author) {
        return bookService.findByNameAndAuthor(name, author);
    }
    @GetMapping({"/publisher={publisher}/year={year}","/year={year}/publisher={publisher}"})
    public Optional<BookModel> findByPublisherAndPublishYear(@PathVariable("publisher") String publisher, @PathVariable("year") Integer year) {
        return bookService.findByPublisherAndPublishYear(publisher, year);
    }
    @GetMapping("/year={year}")
    public Optional<BookModel> findByPublishYear(@PathVariable("year") Integer year) {
        return bookService.findByPublishYear(year);
    }
    @GetMapping({"/genre={genre}/author={author}/year={year}","/genre={genre}/year={year}/author={author}","/author={author}/genre={genre}/year={year}",
            "/author={author}/year={year}/genre={genre}","/year={year}/author={author}/genre={genre}","/year={year}/genre={genre}/author={author}"})
    public Optional<BookModel> findByGenreAndAuthorAndPublishYear(@PathVariable("genre") String genre, @PathVariable("author") String author, @PathVariable("year") Integer year) {
        return bookService.findByGenreAndAuthorAndPublishYear(genre, author, year);
    }
    @GetMapping("/description={description}")
    public Optional<BookModel> findByDescriptionContaining(@PathVariable("description") String description) {
        return bookService.findByDescriptionContaining(description);
    }
}
