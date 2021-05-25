package com.leonelm.mundodisney.service;

import com.leonelm.mundodisney.model.Personaje;
import com.leonelm.mundodisney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonajeService {
    private final PersonajeRepository personajeRepository;
    @Autowired
    public PersonajeService(PersonajeRepository personajeRepository){
        this.personajeRepository = personajeRepository;
    }

    public List<Object> getPersonajes(){
        return personajeRepository.getPersonajes();
    }

}
