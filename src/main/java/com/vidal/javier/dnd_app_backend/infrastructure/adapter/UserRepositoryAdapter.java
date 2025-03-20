package com.vidal.javier.dnd_app_backend.infrastructure.adapter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vidal.javier.dnd_app_backend.domain.model.User;
import com.vidal.javier.dnd_app_backend.domain.repository.UserRepository;
import com.vidal.javier.dnd_app_backend.persistence.entity.UserEntity;
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
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(UUID id) {

    }

    @Override
    public boolean existsById(UUID id) {

    }

    @Override
    public Optional<User> findByUsername(String username) {

    }

    @Override
    public boolean existsByUsername(String username) {

    }

    @Override
    public Optional<User> findByEmail(String email) {

    }

    @Override
    public boolean existsByEmail(String email) {

    }

    @Override
    public User save(User user) {

    }

    @Override
    public boolean update(User user) {

    }

    @Override
    public boolean delete(User user) {

    }

    private User toDomain(UserEntity entity) {
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
                entity.getCharacters(),
                entity.getWorlds());
    }

}
