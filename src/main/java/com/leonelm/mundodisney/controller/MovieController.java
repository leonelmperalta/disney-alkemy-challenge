package com.leonelm.mundodisney.controller;

import com.leonelm.mundodisney.model.Movie;
import com.leonelm.mundodisney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping(value="/{id}")
    public Movie getMovieDetail(@PathVariable Long id){
        return movieService.getMovieDetail(id);
    }
}
