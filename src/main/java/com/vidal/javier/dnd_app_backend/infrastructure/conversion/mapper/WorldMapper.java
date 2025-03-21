package com.vidal.javier.dnd_app_backend.infrastructure.conversion.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vidal.javier.dnd_app_backend.persistence.entity.WorldEntity;
import com.vidal.javier.dnd_app_backend.domain.model.World;

@Component
public class WorldMapper {

    private final UserMapper userMapper;

    @Autowired
    public WorldMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public World toDomain(WorldEntity entity) {
        return new World(
                entity.getId(),
                entity.getName(),
                userMapper.toDomain(entity.getUser()));
    }

    public WorldEntity toEntity(World model) {
        return new WorldEntity(
                model.getId(),
                model.getName(),
                userMapper.toEntity(model.getUser()));
    }

    public List<World> worldListToDomain(List<WorldEntity> entities) {
        return entities.stream()
                .map(entity -> toDomain(entity))
                .toList();
    }

    public List<WorldEntity> worldListToEntity(List<World> models) {
        return models.stream()
                .map(model -> toEntity(model))
                .toList();
    }

}
