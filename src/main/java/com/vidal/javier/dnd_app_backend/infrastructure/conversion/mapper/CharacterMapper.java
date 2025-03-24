package com.vidal.javier.dnd_app_backend.infrastructure.conversion.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vidal.javier.dnd_app_backend.domain.model.Character;
import com.vidal.javier.dnd_app_backend.infrastructure.persistence.entity.CharacterEntity;

@Component
public class CharacterMapper {

    private final UserMapper userMapper;

    @Autowired
    public CharacterMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public Character toDomain(CharacterEntity entity) {
        return new Character(
                entity.getId(),
                entity.getName(),
                userMapper.toDomain(entity.getUser()));
    }

    public CharacterEntity toEntity(Character model) {
        return new CharacterEntity(
                model.getId(),
                model.getName(),
                userMapper.toEntity(model.getUser()));
    }

    public List<Character> characterListToDomain(List<CharacterEntity> entities) {
        return entities.stream()
                .map(entity -> toDomain(entity))
                .toList();
    }

    public List<CharacterEntity> characterListToEntity(List<Character> models) {
        return models.stream()
                .map(model -> toEntity(model))
                .toList();
    }

}
