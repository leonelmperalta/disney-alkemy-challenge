package com.leonelm.mundodisney.repository;

import com.leonelm.mundodisney.model.Personaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Long> {
    @Query(value = "SELECT P.id, P.nombre, P.imagen FROM Personaje P")
    List<Object> getPersonajes();

    @Query(value = "SELECT P FROM Personaje P WHERE P.nombre = ?1")
    Optional<Personaje> findPersonajeByNombre(String nombre);
}
