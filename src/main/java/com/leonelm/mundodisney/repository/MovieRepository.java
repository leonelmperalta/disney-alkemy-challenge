package com.leonelm.mundodisney.repository;

import com.leonelm.mundodisney.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
