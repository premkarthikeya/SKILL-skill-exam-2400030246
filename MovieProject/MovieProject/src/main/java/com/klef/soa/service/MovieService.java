package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Movie;

public interface MovieService
{
    Movie addMovie(Movie m);
    Movie updateMovie(Movie m);
    List<Movie> displayAllMovies();
    Movie displayMovieById(Long id);
    String deleteMovieById(Long id);
    List<Movie> displayMoviesByDirector(String director);
    List<Movie> displayMoviesByGenre(String genre);
}