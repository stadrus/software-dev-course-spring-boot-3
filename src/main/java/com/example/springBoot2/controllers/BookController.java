package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final List<Book> books = List.of(
        new Book("The Catcher in the Rye", "J.D. Salinger", 1951, 234),
        new Book("To Kill a Mockingbird", "Harper Lee", 1960, 281),
        new Book("1984", "George Orwell", 1949, 328)
    );

    @GetMapping
    public List<Book> getBooks() {
        return books;
    }
}
