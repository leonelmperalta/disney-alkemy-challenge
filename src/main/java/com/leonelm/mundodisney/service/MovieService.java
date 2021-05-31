package com.leonelm.mundodisney.service;

import com.leonelm.mundodisney.model.Character;
import com.leonelm.mundodisney.model.Movie;
import com.leonelm.mundodisney.repository.MovieRepository;
import com.leonelm.mundodisney.service.util.CharacterDTO;
import com.leonelm.mundodisney.service.util.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }


    public List<MovieDTO> getMovies(){
        List<Movie> movies = movieRepository.findAll();
        List<MovieDTO> moviesDTO = new ArrayList<MovieDTO>();
        for (Movie m:
                movies) {
            moviesDTO.add(new MovieDTO(m.getId(),m.getTitle(),m.getUrl(), m.getCreationDate()));
        }
        return moviesDTO;
    }

    public Movie getMovieDetail(Long id){
        Movie movie = movieRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Movie with id: " + id + ", dont exist in system.")
        );
        return movie;
    }

    public void createMovie(Movie movie) {
        if(movie.getQualification() > 5 || movie.getQualification() < 0){
            throw new IllegalStateException("Movie qualification must be between 0 and 5.");
        }
        movieRepository.save(movie);
    }

    @Transactional
    public void updateMovie(Long id, Movie movie) {
        Movie movieToUpdate = movieRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException("Character with id: " + id + ", dont exists in system.")
                );

        if(movie.getQualification() > 5 || movie.getQualification() < 0){
            throw new IllegalStateException("Movie qualification must be between 0 and 5.");
        }
        movieToUpdate.setTitle(movie.getTitle());
        movieToUpdate.setUrl(movie.getUrl());
        movieToUpdate.setCreationDate(movie.getCreationDate());
        movieToUpdate.setGenre(movie.getGenre());
        movieToUpdate.setQualification(movie.getQualification());
        movieToUpdate.setAsociatedCharacters(movie.getAsociatedCharacters());
    }

    public void deleteMovie(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if(movieOptional.isEmpty()){
            throw new IllegalStateException("Character with id: " + id + ", dont exists in system.");
        }
        movieRepository.delete(movieOptional.get());
    }
}
