package com.leonelm.mundodisney.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Personaje{
    @Id
    @SequenceGenerator(
            name = "personaje_sequence",
            sequenceName = "personaje_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "personaje_sequence"
    )
    private Long id;
    private String imagen;
    private String nombre;
    private int edad;
    private float peso;
    private String historia;
    @ManyToMany
    @JoinTable(
            name= "actuaciones",
            joinColumns = @JoinColumn(name = "idPersonaje"),
            inverseJoinColumns = @JoinColumn(name = "idPelicula")
    )
    private  Set<Pelicula> peliculasAsociadas;

    public Personaje() {
    }

    public Personaje(String imagen, String nombre, int edad, float peso, String historia) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
    }

    public Personaje(String imagen, String nombre, int edad, float peso, String historia, Set<Pelicula> peliculasAsociadas) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculasAsociadas = peliculasAsociadas;
    }

    public Personaje(Long id, String imagen, String nombre, int edad, float peso, String historia, Set<Pelicula> peliculasAsociadas) {
        this.id = id;
        this.imagen = imagen;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.historia = historia;
        this.peliculasAsociadas = peliculasAsociadas;
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

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public Set<Pelicula> getPeliculasAsociadas() {
        return peliculasAsociadas;
    }

    public void setPeliculasAsociadas(Set<Pelicula> peliculasAsociadas) {
        this.peliculasAsociadas = peliculasAsociadas;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", imagen='" + imagen + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", historia='" + historia + '\'' +
                ", peliculasAsociadas=" + peliculasAsociadas +
                '}';
    }
}
