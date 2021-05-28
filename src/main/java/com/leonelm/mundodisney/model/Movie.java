package com.leonelm.mundodisney.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
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
    private Long id;
    private String url;
    private String title;
    private LocalDate creationDate;
    private int qualification;
    @ManyToMany(mappedBy = "asociatedMovies")
    private Set<Character> asociatedCharacters;
    @ManyToOne
    @JoinColumn(name="idGenre",nullable = false)
    private Genre genre;

    public Movie() {
    }

    public Movie(String url, String title, LocalDate creationDate, int qualification, Set<Character> asociatedCharacters, Genre genre) {
        this.url = url;
        this.title = title;
        this.creationDate = creationDate;
        this.qualification = qualification;
        this.asociatedCharacters = asociatedCharacters;
        this.genre = genre;
    }

    public Movie(Long id, String url, String title, LocalDate creationDate, int qualification, Set<Character> asociatedCharacters, Genre genre) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.creationDate = creationDate;
        this.qualification = qualification;
        this.asociatedCharacters = asociatedCharacters;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public int getQualification() {
        return qualification;
    }

    public Set<Character> getAsociatedCharacters() {
        return asociatedCharacters;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", creationDate=" + creationDate +
                ", qualification=" + qualification +
                ", asociatedCharacters=" + asociatedCharacters +
                ", genre=" + genre +
                '}';
    }
}
