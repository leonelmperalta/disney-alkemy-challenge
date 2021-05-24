package com.leonelm.mundodisney.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Pelicula {
    @Id
    @SequenceGenerator(
            name = "pelicula_sequence",
            sequenceName = "pelicula_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "pelicula_sequence"
    )
    private Long id;
    private final String imagen;
    private final String titulo;
    private final LocalDate fechaDeCreacion;
    private final int calificacion;
    @ManyToMany(mappedBy = "peliculasAsociadas")
    private final Set<Personaje> personajesAsociados;
    @ManyToOne
    @JoinColumn(name="idGenero",nullable = false)
    private Genero genero;

    public Pelicula(String imagen, String titulo, LocalDate fechaDeCreacion, int calificacion, Set<Personaje> personajesAsociados) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.fechaDeCreacion = fechaDeCreacion;
        this.calificacion = calificacion;
        this.personajesAsociados = personajesAsociados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public Set<Personaje> getPersonajesAsociados() {
        return personajesAsociados;
    }
}
