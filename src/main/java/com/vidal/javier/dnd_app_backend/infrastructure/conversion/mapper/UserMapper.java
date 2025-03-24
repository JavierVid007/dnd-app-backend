package com.vidal.javier.dnd_app_backend.infrastructure.conversion.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vidal.javier.dnd_app_backend.domain.model.User;
import com.vidal.javier.dnd_app_backend.infrastructure.persistence.entity.UserEntity;

@Component
public class UserMapper {

    private final CharacterMapper characterMapper;
    private final WorldMapper worldMapper;

    @Autowired
    public UserMapper(CharacterMapper characterMapper, WorldMapper worldMapper) {
        this.characterMapper = characterMapper;
        this.worldMapper = worldMapper;
    }

    public User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getBio(),
                entity.getRole(),
                entity.getAvatarUrl(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getLastLogin(),
                characterMapper.characterListToDomain(entity.getCharacters()),
                worldMapper.worldListToDomain(entity.getWorlds()));
    }

    public UserEntity toEntity(User model) {
        return new UserEntity(
                model.getId(),
                model.getUsername(),
                model.getEmail(),
                model.getPassword(),
                model.getFirstName(),
                model.getLastName(),
                model.getBio(),
                model.getRole(),
                model.getAvatarUrl(),
                model.getCreatedAt(),
                model.getUpdatedAt(),
                model.getLastLogin(),
                characterMapper.characterListToEntity(model.getCharacters()),
                worldMapper.worldListToEntity(model.getWorlds()));
    }

    public List<User> userListToDomain(List<UserEntity> entities) {
        return entities.stream()
                .map(entity -> toDomain(entity))
                .toList();
    }

    public List<UserEntity> userListToEntity(List<User> models) {
        return models.stream()
                .map(model -> toEntity(model))
                .toList();
    }

}
