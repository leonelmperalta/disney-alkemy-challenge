package com.leonelm.mundodisney.service;

import com.leonelm.mundodisney.model.Personaje;
import com.leonelm.mundodisney.repository.PersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        personajeToUpdate.setNombre(personaje.getNombre());
        personajeToUpdate.setImagen(personaje.getImagen());
        personajeToUpdate.setEdad(personaje.getEdad());
        personajeToUpdate.setPeso(personaje.getPeso());
        personajeToUpdate.setHistoria(personaje.getHistoria());
    }

    public Personaje getDetallePersonaje(Long id) {
        Personaje personaje = personajeRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException("El personaje con id: " + id + ", no existe en el sistema.")
                );
        return personaje;
    }
}
