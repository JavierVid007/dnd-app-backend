package com.vidal.javier.dnd_app_backend.infrastructure.conversion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidal.javier.dnd_app_backend.domain.model.Character;
import com.vidal.javier.dnd_app_backend.infrastructure.conversion.mapper.CharacterMapper;
import com.vidal.javier.dnd_app_backend.infrastructure.persistence.entity.CharacterEntity;

@Service
public class CharacterConversionService {

    private final CharacterMapper mapper;

    @Autowired
    public CharacterConversionService(CharacterMapper mapper) {
        this.mapper = mapper;
    }

    public Character toDomain(CharacterEntity entity) {
        return mapper.toDomain(entity);
    }

    public CharacterEntity toEntity(Character model) {
        return mapper.toEntity(model);
    }

    public List<Character> characterListToDomain(List<CharacterEntity> entities) {
        return mapper.characterListToDomain(entities);
    }

    public List<CharacterEntity> characterListToEntity(List<Character> models) {
        return mapper.characterListToEntity(models);
    }

}