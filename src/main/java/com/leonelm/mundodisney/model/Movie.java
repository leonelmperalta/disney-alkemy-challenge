package com.leonelm.mundodisney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name= "movies")
@Data
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    @Column(name = "movie_id",nullable = false)
    private Long id;
    @Column(name= "url")
    private String url;
    @Column(name="title")
    private String title;
    @Column(name="creationDate")
    private LocalDate creationDate;
    @Column(name="qualification")
    private Integer qualification;
    @ManyToMany(mappedBy = "asociatedMovies", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("asociatedMovies")
    @EqualsAndHashCode.Exclude
    private Set<Character> asociatedCharacters;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idGenre")
    @JsonIgnoreProperties("asociatedMovies")
    @EqualsAndHashCode.Exclude
    private Genre genre;
}
