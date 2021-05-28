package com.leonelm.mundodisney.service;

import com.leonelm.mundodisney.model.Movie;
import com.leonelm.mundodisney.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie getMovieDetail(Long id){
        Movie movie = movieRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Movie with id: " + id + ", dont exist in system.")
        );
        return movie;
    }
}
