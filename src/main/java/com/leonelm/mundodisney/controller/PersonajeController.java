package com.leonelm.mundodisney.controller;

import com.leonelm.mundodisney.model.Personaje;
import com.leonelm.mundodisney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class PersonajeController {
    private final PersonajeService personajeService;

    @Autowired
    public PersonajeController(PersonajeService personajeService){
        this.personajeService = personajeService;
    }

    @GetMapping
    public List<Object> getPersonajes(){
        return personajeService.getPersonajes();
    }

    @GetMapping(value = "/{id}")
    public Personaje getDetallePersonaje(@PathVariable Long id){
        return personajeService.getDetallePersonaje(id);
    }

    @PostMapping
    public void createPersonaje(@RequestBody Personaje personaje ) {
        personajeService.addNewPersonaje(personaje);
    }

    @PutMapping(path = "/{id}")
    public void updatePersonaje(@PathVariable Long id, @RequestBody Personaje personaje){
        personajeService.updatePersonaje(id,personaje);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePersonaje(@PathVariable Long id){
        personajeService.deletePersonaje(id);
    }
}
