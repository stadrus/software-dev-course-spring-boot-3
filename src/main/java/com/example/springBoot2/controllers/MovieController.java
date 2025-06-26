package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Movie;
import com.example.springBoot2.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    //Implement the getAllItems method in each of the controllers. This method should call the findAll method on the JPA repository and return the result, and should be annotated with @GetMapping//
    @GetMapping("")
    public List<Movie> getAllItems (){
        return movieRepository.findAll();
    }

    //Implement the getItem method in each of the controllers. This method should call the findById method on the JPA repository and return the result, and should be annotated with @GetMapping('/{id}') and have a mapped @PathVariable parameter for the id of type int.//
    @GetMapping("/movies/{id}")
    public Optional<Movie> getItem(@PathVariable int id){
        return movieRepository.findById(id);
    }
    //Implement the addItem method in each of the controllers. This method should call the save method on the JPA repository and return the result, and should be annotated with @PostMapping with a @RequestBody parameter//
    @PostMapping("/movies")
    public Movie addItem (@RequestBody Movie movie){
        return movieRepository.save(movie);
    }
    //Implement the updateItem method in each of the controllers. This method should call the save method on the JPA repository and return the result, and should be annotated with @PutMapping('/{id}') with a @PathVariable parameter for the id of type int and a @RequestBody parameter.//
    @PutMapping ("/movies/{id}")
    public Movie updateItem (@PathVariable int id, @RequestBody Movie movie){
        movie.setId(id);
        return movieRepository.save(movie);
    }
    //Implement the deleteItem method in each of the controllers. This method should call the deleteById method on the JPA repository and should be annotated with @DeleteMapping('/{id}') with a @PathVariable parameter for the id of type int.
    @DeleteMapping("/movies/{id}")
    public void deleteItem(@PathVariable int id){
        movieRepository.deleteById(id);
    }
}
