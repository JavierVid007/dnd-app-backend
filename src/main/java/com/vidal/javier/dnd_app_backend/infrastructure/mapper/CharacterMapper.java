package com.vidal.javier.dnd_app_backend.infrastructure.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vidal.javier.dnd_app_backend.persistence.entity.CharacterEntity;
import com.vidal.javier.dnd_app_backend.domain.model.Character;

@Component
public class CharacterMapper {

    public static Character toDomain(CharacterEntity entity) {
        return new Character(
                entity.getId(),
                entity.getName(),
                UserMapper.toDomain(entity.getUser()));
    }

    public static CharacterEntity toEntity(Character model) {
        return new CharacterEntity(
                model.getId(),
                model.getName(),
                UserMapper.toEntity(model.getUser()));
    }

    public static List<Character> characterListToDomain(List<CharacterEntity> characters) {
        return characters.stream()
                .map(character -> toDomain(character))
                .toList();
    }

    public static List<CharacterEntity> characterListToEntity(List<Character> characters) {
        return characters.stream()
                .map(character -> toEntity(character))
                .toList();
    }

}
