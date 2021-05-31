package com.leonelm.mundodisney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name= "movies")
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
    @JsonIgnoreProperties("asociatedMovies")
    private Set<Character> asociatedCharacters;
    @ManyToOne
    @JoinColumn(name="idGenre")
    @JsonIgnoreProperties("asociatedMovies")
    private Genre genre;

    public Movie() {
    }

    public Movie(String url, String title, LocalDate creationDate, int qualification) {
        this.url = url;
        this.title = title;
        this.creationDate = creationDate;
        this.qualification = qualification;
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

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public Set<Character> getAsociatedCharacters() {
        return asociatedCharacters;
    }

    public void setAsociatedCharacters(Set<Character> asociatedCharacters) {
        this.asociatedCharacters = asociatedCharacters;
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
