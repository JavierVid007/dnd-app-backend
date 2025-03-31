package com.vidal.javier.dnd_app_backend.infrastructure.persistence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vidal.javier.dnd_app_backend.domain.model.User;
import com.vidal.javier.dnd_app_backend.domain.port.UserPersistencePort;
import com.vidal.javier.dnd_app_backend.infrastructure.persistence.conversion.service.UserConversionService;
import com.vidal.javier.dnd_app_backend.infrastructure.persistence.repository.UserEntityRepository;

@Repository
public class UserRepositoryAdapter implements UserPersistencePort {

    private final UserEntityRepository repository;
    private final UserConversionService conversionService;

    @Autowired
    public UserRepositoryAdapter(UserEntityRepository repository, UserConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    @Override
    public List<User> findAll() {
        return conversionService.userListToDomain(repository.findAll());
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id).map(conversionService::toDomain);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username).map(conversionService::toDomain);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(conversionService::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return conversionService.toDomain(repository.save(conversionService.toEntity(user)));
    }

    @Override
    public boolean update(User user) {
        if (existsById(user.getId())) {
            repository.save(conversionService.toEntity(user));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        if (existsById(user.getId())) {
            repository.delete(conversionService.toEntity(user));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(UUID id) {
        if (existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
