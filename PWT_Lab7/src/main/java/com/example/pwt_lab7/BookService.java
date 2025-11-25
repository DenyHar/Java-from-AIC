package com.example.pwt_lab7;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    public List<BookModel> findAll() {
        return bookRepository.findAll();
    }
    public Optional<BookModel> findByName(@RequestParam String name) {
        return bookRepository.findByName(name);
    }
    public Optional<BookModel> findByAuthor(@RequestParam String name) {
        return bookRepository.findByAuthor(name);
    }
    public Optional<BookModel> findByPages(@RequestParam Integer pages) {
        return bookRepository.findByPages(pages);
    }
    public Optional<BookModel> findByNameAndAuthor(@RequestParam String name, @RequestParam String author) {
        return bookRepository.findByNameAndAuthor(name, author);
    }
    public Optional<BookModel> findByPublisherAndPublishYear(@RequestParam String publisher, @RequestParam Integer year) {
        return bookRepository.findByPublisherAndPublishYear(publisher, year);
    }
    public Optional<BookModel> findByPublishYear(@RequestParam Integer year) {
        return bookRepository.findByPublishYear(year);
    }
    public Optional<BookModel> findByGenreAndAuthorAndPublishYear(String genre, String author, Integer year) {
        return bookRepository.findByGenreAndAuthorAndPublishYear(genre, author, year);
    }
    public Optional<BookModel> findByDescriptionContaining(@RequestParam String description) {
        return bookRepository.findByDescriptionContaining(description);
    }
    public BookModel createBook(@RequestBody BookModel bookModel) {
        if (bookModel.getId()!=null) {
            throw new IllegalArgumentException("Book already exists");
        }
        if(bookRepository.findByName(bookModel.getName()).isPresent()) {
            throw new IllegalArgumentException("Book already exists");
        }
        if(bookModel.getPages() <= 0){
            throw new IllegalArgumentException("Book pages must be greater than 0");
        }
        return bookRepository.save(bookModel);
    }
    public void deleteBook(Long id) {
        if(bookRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Book not found");
        }
        bookRepository.deleteById(id);
    }
    @Transactional
    public void updateBook(Long id, BookModel bookModel) {
        var existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));
        if (bookModel.getName() != null && !bookModel.getName().isBlank() && !existingBook.getName().equals(bookModel.getName())) {
            if (bookRepository.findByName(bookModel.getName()).isPresent()) {
                throw new IllegalArgumentException("Book already exists");
            }
            existingBook.setName(bookModel.getName());
        }
        if (bookModel.getAuthor() != null && !bookModel.getAuthor().isBlank() && !existingBook.getAuthor().equals(bookModel.getAuthor())) {
            existingBook.setAuthor(bookModel.getAuthor());
        }
        if (bookModel.getPublishYear() != null && !existingBook.getPublishYear().equals(bookModel.getPublishYear())) {
            if (bookModel.getPublishYear() <= 0) {
                throw new IllegalArgumentException("Publish year must be greater than 0");
            }
            existingBook.setPublishYear(bookModel.getPublishYear());
        }
        if (bookModel.getPublisher() != null && !bookModel.getPublisher().isBlank() && !existingBook.getPublisher().equals(bookModel.getPublisher())) {
            existingBook.setPublisher(bookModel.getPublisher());
        }
        if (bookModel.getGenre() != null && !bookModel.getGenre().isBlank() && !existingBook.getGenre().equals(bookModel.getGenre())) {
            existingBook.setGenre(bookModel.getGenre());
        }
        if (bookModel.getPages() != null && !existingBook.getPages().equals(bookModel.getPages())) {
            if (bookModel.getPages() <= 0) {
                throw new IllegalArgumentException("Book pages must be greater than 0");
            }
            existingBook.setPages(bookModel.getPages());
        }
        if (bookModel.getDescription() != null && !bookModel.getDescription().isBlank() && !existingBook.getDescription().equals(bookModel.getDescription())) {
            existingBook.setDescription(bookModel.getDescription());
        }
        if (bookModel.getQuantity() != null && !existingBook.getQuantity().equals(bookModel.getQuantity())) {
            if (bookModel.getQuantity() < 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0");
            }
            existingBook.setQuantity(bookModel.getQuantity());
        }
    }
}
