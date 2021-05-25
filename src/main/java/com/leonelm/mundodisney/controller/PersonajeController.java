package com.leonelm.mundodisney.controller;

import com.leonelm.mundodisney.model.Personaje;
import com.leonelm.mundodisney.service.PersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
