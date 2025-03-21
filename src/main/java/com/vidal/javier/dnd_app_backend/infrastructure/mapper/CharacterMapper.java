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

    public static List<Character> characterListToDomain(List<CharacterEntity> entities) {
        return entities.stream()
                .map(entity -> toDomain(entity))
                .toList();
    }

    public static List<CharacterEntity> characterListToEntity(List<Character> models) {
        return models.stream()
                .map(model -> toEntity(model))
                .toList();
    }

}
