package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Book;
import com.example.springBoot2.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book book) {
        book.setId(id);
        bookRepository.save(book);
        return book;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookRepository.deleteById(id);
    }
}
