package com.leonelm.mundodisney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "characters")
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
    private Long id;
    private String url;
    private String name;
    private int age;
    private float weigth;
    private String story;
    @ManyToMany
    @JoinTable(
            name = "performances",
            joinColumns = @JoinColumn(name = "idCharacter"),
            inverseJoinColumns = @JoinColumn(name = "idMovie")
    )
    @JsonIgnoreProperties("asociatedCharacters")
    private Set<Movie> asociatedMovies;

    public Character() {
    }

    public Character(String url, String name, int age, float weigth, String story) {
        this.url = url;
        this.name = name;
        this.age = age;
        this.weigth = weigth;
        this.story = story;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeigth() {
        return weigth;
    }

    public void setWeigth(float weigth) {
        this.weigth = weigth;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Set<Movie> getAsociatedMovies() {
        return asociatedMovies;
    }

    public void setAsociatedMovies(Set<Movie> asociatedMovies) {
        this.asociatedMovies = asociatedMovies;
    }

    public void addAsociatedMovie(Movie movie){
        asociatedMovies.add(movie);
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", weigth=" + weigth +
                ", story='" + story + '\'' +
                ", asociatedMovies=" + asociatedMovies +
                '}';
    }
}
