package com.leonelm.mundodisney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name= "genres")
@Data
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
    @Column(name="genre_id",nullable = false)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="url")
    private String url;
    @OneToMany(mappedBy = "genre", cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("genre")
    @EqualsAndHashCode.Exclude
    private List<Movie> asociatedMovies;

    public Genre(){};

    public Genre(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public void addAsociatedMovie(Movie movie){
        this.asociatedMovies.add(movie);
    }
}
