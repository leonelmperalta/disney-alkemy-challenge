package com.leonelm.mundodisney.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
public class Genre {
    @Id
    @SequenceGenerator(
            name = "genre_sequence",
            sequenceName = "genre_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_sequence"
    )
    private Long id;
    private final String name;
    private final String url;
    @OneToMany(mappedBy = "genre")
    private final Set<Movie> peliculasAsociadas;

    public Genre(String name, String url, Set<Movie> peliculasAsociadas) {
        this.name = name;
        this.url = url;
        this.peliculasAsociadas = peliculasAsociadas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Set<Movie> getPeliculasAsociadas() {
        return peliculasAsociadas;
    }
}
