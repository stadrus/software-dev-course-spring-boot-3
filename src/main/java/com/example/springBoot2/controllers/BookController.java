package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Book;
import com.example.springBoot2.repositories.BookRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    //Implement the getAllItems method in each of the controllers. This method should call the findAll method on the JPA repository and return the result, and should be annotated with @GetMapping//
    @GetMapping("")
    public List<Book> getAllItems (){
        return bookRepository.findAll();
    }

    //Implement the getItem method in each of the controllers. This method should call the findById method on the JPA repository and return the result, and should be annotated with @GetMapping('/{id}') and have a mapped @PathVariable parameter for the id of type int.//
    @GetMapping("/books/{id}")
    public Optional<Book> getItem(@PathVariable int id){
        return bookRepository.findById(id);
    }
    //Implement the addItem method in each of the controllers. This method should call the save method on the JPA repository and return the result, and should be annotated with @PostMapping with a @RequestBody parameter//
    @PostMapping("/books")
    public Book addItem (@RequestBody Book book){
        return bookRepository.save(book);
    }
    //Implement the updateItem method in each of the controllers. This method should call the save method on the JPA repository and return the result, and should be annotated with @PutMapping('/{id}') with a @PathVariable parameter for the id of type int and a @RequestBody parameter.//
    @PutMapping ("/books/{id}")
    public Book updateItem (@PathVariable int id, @RequestBody Book book){
        book.setId(id);
        return bookRepository.save(book);
    }
    //Implement the deleteItem method in each of the controllers. This method should call the deleteById method on the JPA repository and should be annotated with @DeleteMapping('/{id}') with a @PathVariable parameter for the id of type int.
    @DeleteMapping("/books/{id}")
    public void deleteItem(@PathVariable int id){
        bookRepository.deleteById(id);
    }
}
