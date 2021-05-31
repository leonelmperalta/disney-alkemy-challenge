package com.leonelm.mundodisney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "genres")
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
    private String name;
    private String url;
    @OneToMany(mappedBy = "genre")
    private Set<Movie> asociatedMovies;

    public Genre() {
    }

    public Genre(String name, String url, Set<Movie> asociatedMovies) {
        this.name = name;
        this.url = url;
        this.asociatedMovies = asociatedMovies;
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

    public Set<Movie> getAsociatedMovies() {
        return asociatedMovies;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", asociatedMovies=" + asociatedMovies +
                '}';
    }
}
