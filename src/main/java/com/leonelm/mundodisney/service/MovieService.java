package com.leonelm.mundodisney.service;

import com.leonelm.mundodisney.model.Genre;
import com.leonelm.mundodisney.model.Movie;
import com.leonelm.mundodisney.repository.GenreRepository;
import com.leonelm.mundodisney.repository.MovieRepository;
import com.leonelm.mundodisney.util.MovieDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    @Autowired
    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository){
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    /*
    * GET METHODS
    */


    public List<MovieDTO> getMovies(){
        List<Movie> movies = movieRepository.findAll();
        return mapToDTO(movies);
    }

    public List<MovieDTO> getMoviesByGenreId(Long genreId) {
        List<Movie> movies = movieRepository.getMoviesByGenre_Id(genreId);
        return mapToDTO(movies);
    }

    public List<MovieDTO> getMoviesByTitle(String title) {
        List<Movie> movies = movieRepository.findByTitle(title);
        return mapToDTO(movies);
    }

    public Movie getMovieDetail(Long id){
        Movie movie = movieRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("Movie with id: " + id + ", dont exist in system.")
        );
        return movie;
    }

    /*
    *   POST METHODS
    */

    public void createMovie(Movie movie) {
        if(movie.getQualification() > 5 || movie.getQualification() < 0){
            throw new IllegalStateException("Movie qualification must be between 0 and 5.");
        }
        movieRepository.save(movie);
    }

    /*
    *   UPDATE METHODS
    */

    @Transactional
    public void updateMovie(Long id, Movie movie) {
        Movie movieToUpdate = movieRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException("Movie with id: " + id + ", dont exists in system.")
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

    @Transactional
    public void setGenre(Long id, Long genreId) {
        Movie movie = movieRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException("Movie with id: " + id + ", dont exists in system.")
                );
        Genre genre = genreRepository.findById(genreId).
                orElseThrow(
                        () -> new IllegalStateException("Genre with id: " + id + ", dont exists in system.")
                );
        movie.setGenre(genre);
        genre.addAsociatedMovie(movie);
    }

    /*
    * DELETE METHODS
    */

    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(
                () -> {throw new IllegalStateException("Movie with id: " + id + ", dont exists in system.");}
        );
        movieRepository.delete(movie);
    }

    /*
     * HELPERS FUNCTIONS
     */

    public List<MovieDTO> mapToDTO(List<Movie> moviesList){
        List<MovieDTO> moviesDTO = new ArrayList<MovieDTO>();
        ModelMapper modelMapper = new ModelMapper();
        for (Movie m:
                moviesList) {
            MovieDTO mDTO = new MovieDTO();
            modelMapper.map(m, mDTO);
            moviesDTO.add(mDTO);
        }
        return moviesDTO;
    }
}
