package com.vidal.javier.dnd_app_backend.infrastructure.conversion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vidal.javier.dnd_app_backend.domain.model.User;
import com.vidal.javier.dnd_app_backend.infrastructure.conversion.mapper.UserMapper;
import com.vidal.javier.dnd_app_backend.infrastructure.persistence.entity.UserEntity;

@Service
public class UserConversionService {

    private final UserMapper mapper;

    @Autowired
    public UserConversionService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public User toDomain(UserEntity entity) {
        return mapper.toDomain(entity);
    }

    public UserEntity toEntity(User model) {
        return mapper.toEntity(model);
    }

    public List<User> userListToDomain(List<UserEntity> entities) {
        return mapper.userListToDomain(entities);
    }

    public List<UserEntity> userListToEntity(List<User> models) {
        return mapper.userListToEntity(models);
    }

}
