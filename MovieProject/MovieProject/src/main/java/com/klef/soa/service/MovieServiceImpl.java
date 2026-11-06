package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Movie;
import com.klef.soa.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService
{
    @Autowired
    private MovieRepository repo;

    @Override
    public Movie addMovie(Movie m)
    {
        return repo.save(m);
    }

    @Override
    public Movie updateMovie(Movie m)
    {
        Optional<Movie> optional = repo.findById(m.getMovieId());

        if(optional.isPresent())
        {
            Movie movie = optional.get();

            movie.setTitle(m.getTitle());
            movie.setDirector(m.getDirector());
            movie.setGenre(m.getGenre());
            movie.setLanguage(m.getLanguage());
            movie.setRating(m.getRating());

            return repo.save(movie);
        }
        else
        {
            return null;
        }
    }

    @Override
    public List<Movie> displayAllMovies()
    {
        return repo.findAll();
    }

    @Override
    public Movie displayMovieById(Long id)
    {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String deleteMovieById(Long id)
    {
        boolean flag = repo.existsById(id);

        if(flag)
        {
            repo.deleteById(id);
            return "Movie Deleted Successfully";
        }
        else
        {
            return "Movie Id Not Found";
        }
    }

    @Override
    public List<Movie> displayMoviesByDirector(String director)
    {
        return repo.findByDirector(director);
    }

    @Override
    public List<Movie> displayMoviesByGenre(String genre)
    {
        return repo.findByGenre(genre);
    }
}