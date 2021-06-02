package com.leonelm.mundodisney.repository;

import com.leonelm.mundodisney.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title);
    List<Movie> findByTitleOrderByCreationDateAsc(String title);
    List<Movie> findByTitleOrderByCreationDateDesc(String title);
    List<Movie> getMoviesByGenre_Id(Long genreId);
    List<Movie> getMoviesByGenre_IdOrderByCreationDateAsc(Long genreId);
    List<Movie> getMoviesByGenre_IdOrderByCreationDateDesc(Long genreId);
    List<Movie> findAllByOrderByCreationDateAsc();
    List<Movie> findAllByOrderByCreationDateDesc();
}
