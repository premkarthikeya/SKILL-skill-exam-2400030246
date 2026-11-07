package com.klef.soa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import com.klef.soa.entity.Movie;
import com.klef.soa.repository.MovieRepository;

@org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest
class MovieRepositoryTesting {

    @Autowired
    private MovieRepository movieRepository;

    @Test
    void testSaveMovie() {
        Movie m = new Movie();
        m.setTitle("RRR");
        m.setDirector("Rajamouli");
        m.setGenre("Action");
        m.setLanguage("Telugu");
        m.setRating(9.0);

        Movie saved = movieRepository.save(m);

        assertNotNull(saved.getMovieId());
    }

    @Test
    void testFindMovieById() {
        Movie m = new Movie();
        m.setTitle("Leo");
        m.setDirector("Lokesh");
        m.setGenre("Action");
        m.setLanguage("Tamil");
        m.setRating(8.5);

        Movie saved = movieRepository.save(m);

        assertTrue(movieRepository.findById(saved.getMovieId()).isPresent());
    }

    @Test
    void testFindByDirector() {
        Movie m = new Movie();
        m.setTitle("Baahubali");
        m.setDirector("Rajamouli");
        m.setGenre("Action");
        m.setLanguage("Telugu");
        m.setRating(9.0);

        movieRepository.save(m);

        List<Movie> list = movieRepository.findByDirector("Rajamouli");

        assertFalse(list.isEmpty());
    }

    @Test
    void testFindByGenre() {
        Movie m = new Movie();
        m.setTitle("Jawan");
        m.setDirector("Atlee");
        m.setGenre("Action");
        m.setLanguage("Hindi");
        m.setRating(7.5);

        movieRepository.save(m);

        List<Movie> list = movieRepository.findByGenre("Action");

        assertFalse(list.isEmpty());
    }
}