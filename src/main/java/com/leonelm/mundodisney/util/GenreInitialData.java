package com.leonelm.mundodisney.util;

import com.leonelm.mundodisney.model.Genre;
import com.leonelm.mundodisney.model.User;
import com.leonelm.mundodisney.repository.GenreRepository;
import com.leonelm.mundodisney.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GenreInitialData {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private UserRepository userRepository;

    @Bean
    CommandLineRunner commandLineRunner(GenreRepository genreRepository){
        return args -> {
            genreRepository.save(new Genre("Comedy", "www.comedy.com/img"));
            genreRepository.save(new Genre("Drama", "www.drama.com/img"));
            genreRepository.save(new Genre("Fantasy", "www.fantasy.com/img"));
            genreRepository.save(new Genre("Action", "www.action.com/img"));
            genreRepository.save(new Genre("Mystery", "www.mistery.com/img"));
        };
    }

}
