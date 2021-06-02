package com.leonelm.mundodisney.controller;

import com.leonelm.mundodisney.model.Genre;
import com.leonelm.mundodisney.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenreService genreService;
    @Autowired
    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getGenres(){
        return genreService.getGenres();
    }

}
