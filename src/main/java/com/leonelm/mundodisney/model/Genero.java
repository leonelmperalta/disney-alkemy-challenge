package com.leonelm.mundodisney.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Genero {
    @Id
    @SequenceGenerator(
            name = "genero_sequence",
            sequenceName = "genero_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genero_sequence"
    )
    private Long id;
    private final String nombre;
    private final String imagen;
    @OneToMany(mappedBy = "genero")
    private final Set<Pelicula> peliculasAsociadas;

    public Genero(String nombre, String imagen, Set<Pelicula> peliculasAsociadas) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.peliculasAsociadas = peliculasAsociadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public Set<Pelicula> getPeliculasAsociadas() {
        return peliculasAsociadas;
    }
}
