package com.leonelm.mundodisney.repository;

import com.leonelm.mundodisney.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
    public List<Character> findByName(String name);
    public List<Character> findByAge(Integer age);
    public List<Character> findByAsociatedMovies_Id(Long id);
}
