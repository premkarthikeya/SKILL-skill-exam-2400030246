package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Movie;
import com.klef.soa.service.MovieService;

@RestController
@RequestMapping("/movie")
public class MovieController
{
    @Autowired
    private MovieService service;
    
    public void Controller(MovieService service) {
        this.service = service;
    }
    
    @GetMapping("/")
    public String home() {
        return "Movie Project is running";
    }
    
    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie)
    {
        return service.addMovie(movie);
    }

    @PutMapping("/update")
    public Movie updateMovie(@RequestBody Movie movie)
    {
        return service.updateMovie(movie);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovieById(@PathVariable Long id)
    {
        return service.deleteMovieById(id);
    }

    @GetMapping("/displayall")
    public List<Movie> displayAllMovies()
    {
        return service.displayAllMovies();
    }

    @GetMapping("/display/{id}")
    public Movie displayMovieById(@PathVariable Long id)
    {
        return service.displayMovieById(id);
    }

    @GetMapping("/director/{director}")
    public List<Movie> displayMoviesByDirector(@PathVariable String director)
    {
        return service.displayMoviesByDirector(director);
    }

    @GetMapping("/genre/{genre}")
    public List<Movie> displayMoviesByGenre(@PathVariable String genre)
    {
        return service.displayMoviesByGenre(genre);
    }
}