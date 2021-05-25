package com.leonelm.mundodisney.repository;

import com.leonelm.mundodisney.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
    @Query(value = "SELECT P.nombre, P.imagen FROM Personaje P")
    List<Object> getPersonajes();
}
