package com.vidal.javier.dnd_app_backend.infrastructure.conversion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidal.javier.dnd_app_backend.domain.model.World;
import com.vidal.javier.dnd_app_backend.infrastructure.conversion.mapper.WorldMapper;
import com.vidal.javier.dnd_app_backend.infrastructure.persistence.entity.WorldEntity;

@Service
public class WorldConversionService {

    private final WorldMapper mapper;

    @Autowired
    public WorldConversionService(WorldMapper mapper) {
        this.mapper = mapper;
    }

    public World toDomain(WorldEntity entity) {
        return mapper.toDomain(entity);
    }

    public WorldEntity toEntity(World model) {
        return mapper.toEntity(model);
    }

    public List<World> worldListToDomain(List<WorldEntity> entities) {
        return mapper.worldListToDomain(entities);
    }

    public List<WorldEntity> worldListToEntity(List<World> models) {
        return mapper.worldListToEntity(models);
    }

}