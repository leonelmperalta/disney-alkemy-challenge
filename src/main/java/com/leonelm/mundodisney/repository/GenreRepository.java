package com.leonelm.mundodisney.repository;

import com.leonelm.mundodisney.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}
