package com.leonelm.mundodisney.service;

import com.leonelm.mundodisney.model.Personaje;
import com.leonelm.mundodisney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Parameter;
import java.util.List;
import java.util.Optional;

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

    public void addNewPersonaje(Personaje personaje) {
        if(nameExistsInBD(personaje.getNombre())){
            throw new IllegalStateException("El nombre del personaje ya esta registrado.");
        }
        personajeRepository.save(personaje);
    }

    public void deletePersonaje(Long id) {
        Optional<Personaje> personajeOptional = personajeRepository.findById(id);
        if(personajeOptional.isEmpty()){
            throw new IllegalStateException("El personaje con id: " + id + ", no existe en el sistema.");
        }
        personajeRepository.delete(personajeOptional.get());
    }

    @Transactional
    public void updatePersonaje(Long id, Personaje personaje) {
        Personaje personajeToUpdate = personajeRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException("El personaje con id: " + id + ", no existe en el sistema.")
                );
        if(personaje.getImagen().length() > 0
                && personaje.getImagen() != null
                && !personaje.getHistoria().equals(personajeToUpdate.getHistoria())){
            personajeToUpdate.setImagen(personaje.getImagen());
        }
        if(personaje.getNombre().length() > 0
                && personaje.getNombre() != null
                && !personaje.getNombre().equals(personajeToUpdate.getNombre())){
            if(nameExistsInBD(personaje.getNombre())){
                throw new IllegalStateException("El nombre del personaje ya esta registrado.");
            }
            personajeToUpdate.setNombre(personaje.getNombre());
        }
        if(personaje.getHistoria().length() > 0
                && personaje.getHistoria() != null
                && !personaje.getHistoria().equals(personajeToUpdate.getHistoria())){
            personajeToUpdate.setHistoria(personaje.getHistoria());
        }
        if(personaje.getEdad() != personajeToUpdate.getEdad()){
            personajeToUpdate.setEdad(personaje.getEdad());
        }
        if(personaje.getPeso() != personaje.getPeso()){
            personajeToUpdate.setPeso(personaje.getPeso());
        }


    }

    public Personaje getDetallePersonaje(Long id) {
        Personaje personaje = personajeRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException("El personaje con id: " + id + ", no existe en el sistema.")
                );
        return personaje;
    }

    private boolean nameExistsInBD(String nombre) {
        Optional<Personaje> personajeOptional = personajeRepository.findPersonajeByNombre(nombre);
        return personajeOptional.isPresent();
    }
}
