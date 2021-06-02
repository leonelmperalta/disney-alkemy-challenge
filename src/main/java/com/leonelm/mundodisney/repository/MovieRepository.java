package com.leonelm.mundodisney.repository;

import com.leonelm.mundodisney.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitle(String title);

    @Query(value = "SELECT DISTINCT m FROM Movie m JOIN m.genre g WHERE g.id = ?1")
    List<Movie> getMoviesByGenreId(Long genreId);
}
