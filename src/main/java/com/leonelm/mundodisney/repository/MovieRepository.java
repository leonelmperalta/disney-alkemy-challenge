package com.leonelm.mundodisney.repository;

import com.leonelm.mundodisney.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title);
    List<Movie> getMoviesByGenre_Id(Long genreId);
}
