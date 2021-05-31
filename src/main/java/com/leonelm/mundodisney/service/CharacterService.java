package com.leonelm.mundodisney.service;

import com.leonelm.mundodisney.model.Character;
import com.leonelm.mundodisney.repository.CharacterRepository;
import com.leonelm.mundodisney.service.util.CharacterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;
    @Autowired
    public CharacterService(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    public List<CharacterDTO> getCharacters(){
        List<Character> characters = characterRepository.findAll();
        List<CharacterDTO> charactersDTO = new ArrayList<CharacterDTO>();
        for (Character ch:
             characters) {
            charactersDTO.add(new CharacterDTO(ch.getId(),ch.getName(),ch.getUrl()));
        }
        return charactersDTO;
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
        characterToUpdate.setName(character.getName());
        characterToUpdate.setUrl(character.getUrl());
        characterToUpdate.setAge(character.getAge());
        characterToUpdate.setWeigth(character.getWeigth());
        characterToUpdate.setStory(character.getStory());
    }
}
