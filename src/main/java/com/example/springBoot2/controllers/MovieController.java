package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Movie;
import com.example.springBoot2.repositories.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieRepository movieRepository;

    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieRepository.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Integer id) {
        return movieRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Movie createMovie(@RequestBody Movie movie) {
        movieRepository.save(movie);
        return movie;
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Integer id, @RequestBody Movie movie) {
        movie.setId(id);
        movieRepository.save(movie);
        return movie;
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Integer id) {
        movieRepository.deleteById(id);
    }
}
