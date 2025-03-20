package com.vidal.javier.dnd_app_backend.infrastructure.mapper;

import org.springframework.stereotype.Component;

import com.vidal.javier.dnd_app_backend.domain.model.User;
import com.vidal.javier.dnd_app_backend.persistence.entity.UserEntity;

@Component
public class UserMapper {

    public static User toDomain(UserEntity entity) {
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
                CharacterMapper.characterListToDomain(entity.getCharacters()),
                WorldMapper.worldListToDomain(entity.getWorlds()));
    }

    public static UserEntity toEntity(User model) {
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
                CharacterMapper.characterListToEntity(model.getCharacters()),
                WorldMapper.worldListToEntity(model.getWorlds()));
    }

}
