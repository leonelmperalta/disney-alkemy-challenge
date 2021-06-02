package com.leonelm.mundodisney.service;

import com.leonelm.mundodisney.model.Character;
import com.leonelm.mundodisney.model.Movie;
import com.leonelm.mundodisney.repository.CharacterRepository;
import com.leonelm.mundodisney.repository.MovieRepository;
import com.leonelm.mundodisney.util.CharacterDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    private final MovieRepository movieRepository;
    @Autowired
    public CharacterService(CharacterRepository characterRepository, MovieRepository movieRepository){
        this.characterRepository = characterRepository;
        this.movieRepository = movieRepository;
    }

    public List<CharacterDTO> mapToDTO(List<Character> charactersList){
        List<CharacterDTO> charactersDTO = new ArrayList<CharacterDTO>();
        ModelMapper modelMapper = new ModelMapper();
        for (Character ch:
                charactersList) {
            CharacterDTO chDTO = new CharacterDTO();
            modelMapper.map(ch,chDTO);
            charactersDTO.add(chDTO);
        }
        return charactersDTO;
    }

    public List<CharacterDTO> getCharacters(){
        List<Character> characters = characterRepository.findAll();
        return mapToDTO(characters);
    }

    public List<CharacterDTO> getCharactersByName(String name) {
        List<Character> characters = characterRepository.findByName(name);
        return mapToDTO(characters);
    }

    public Character getCharacterDetail(Long id) {
        Character character = characterRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException("Character with id: " + id + ", dont exists in system.")
                );
        return character;
    }

    public void createCharacter(Character character) {
        characterRepository.save(character);
    }

    public void deleteCharacter(Long id) {
        Optional<Character> characterOptional = characterRepository.findById(id);
        if(characterOptional.isEmpty()){
            throw new IllegalStateException("Character with id: " + id + ", dont exists in system.");
        }
        characterRepository.delete(characterOptional.get());
    }

    @Transactional
    public void updateCharacter(Long id, Character character) {
        Character characterToUpdate = characterRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException("Character with id: " + id + ", dont exists in system.")
                );
        System.out.println(character);
        characterToUpdate.setName(character.getName());
        characterToUpdate.setUrl(character.getUrl());
        characterToUpdate.setAge(character.getAge());
        characterToUpdate.setWeight(character.getWeight());
        characterToUpdate.setStory(character.getStory());
    }

    @Transactional
    public void setAsociatedMovie(Long id, Long movieId) {
        Character characterToUpdate = characterRepository.findById(id).
                orElseThrow(
                        () -> new IllegalStateException("Character with id: " + id + ", dont exists in system.")
                );
        Movie movieToAdd = movieRepository.findById(movieId).
                orElseThrow(
                () ->  new IllegalStateException("Movie with id: " + id + ", dont exists in system.")
                );
        characterToUpdate.addAsociatedMovie(movieToAdd);
    }
}
