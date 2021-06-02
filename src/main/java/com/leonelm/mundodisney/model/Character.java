package com.leonelm.mundodisney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "characters")
@Data
public class Character {
    @Id
    @SequenceGenerator(
            name = "character_sequence",
            sequenceName = "character_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "character_sequence"
    )
    @Column(name = "character_id", nullable = false)
    private Long id;
    @Column(name="url")
    private String url;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private Integer age;
    @Column(name="weight")
    private float weight;
    @Column(name="story")
    private String story;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name = "performances",
            joinColumns = @JoinColumn(name = "idCharacter"),
            inverseJoinColumns = @JoinColumn(name = "idMovie")
    )
    @JsonIgnoreProperties("asociatedCharacters")
    @EqualsAndHashCode.Exclude
    private Set<Movie> asociatedMovies;

    public void addAsociatedMovie(Movie movie){
        asociatedMovies.add(movie);
    }
}
