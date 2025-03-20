package com.vidal.javier.dnd_app_backend.infrastructure.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.vidal.javier.dnd_app_backend.persistence.entity.WorldEntity;
import com.vidal.javier.dnd_app_backend.domain.model.World;

@Component
public class WorldMapper {

    public static World toDomain(WorldEntity entity) {
        return new World(
                entity.getId(),
                entity.getName(),
                UserMapper.toDomain(entity.getUser()));
    }

    public static WorldEntity toEntity(World model) {
        return new WorldEntity(
                model.getId(),
                model.getName(),
                UserMapper.toEntity(model.getUser()));
    }

    public static List<World> worldListToDomain(List<WorldEntity> worlds) {
        return worlds.stream()
                .map(world -> toDomain(world))
                .toList();
    }

    public static List<WorldEntity> worldListToEntity(List<World> worlds) {
        return worlds.stream()
                .map(world -> toEntity(world))
                .toList();
    }

}
