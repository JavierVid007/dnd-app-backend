package com.vidal.javier.dnd_app_backend.infrastructure.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vidal.javier.dnd_app_backend.domain.model.User;
import com.vidal.javier.dnd_app_backend.domain.repository.UserRepository;
import com.vidal.javier.dnd_app_backend.infrastructure.mapper.UserMapper;
import com.vidal.javier.dnd_app_backend.persistence.repository.UserEntityRepository;

@Repository
public class UserRepositoryAdapter implements UserRepository {

    private final UserEntityRepository repository;

    @Autowired
    public UserRepositoryAdapter(UserEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return UserMapper.userListToDomain(repository.findAll());
    }

    @Override
    public Optional<User> findById(UUID id) {
        return repository.findById(id).map(UserMapper::toDomain);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username).map(UserMapper::toDomain);
    }

    @Override
    public boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(UserMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public User save(User user) {
        return UserMapper.toDomain(repository.save(UserMapper.toEntity(user)));
    }

    @Override
    public boolean update(User user) {
        if (existsById(user.getId())) {
            repository.save(UserMapper.toEntity(user));
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        if (existsById(user.getId())) {
            repository.delete(UserMapper.toEntity(user));
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
