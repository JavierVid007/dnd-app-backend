package com.vidal.javier.dnd_app_backend.domain.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.vidal.javier.dnd_app_backend.domain.model.User;

public interface UserRepository {

    List<User> findAll();

    Optional<User> findById(UUID id);

    boolean existsById(UUID id);

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    User save(User user);

    boolean update(User user);

    boolean delete(User user);

    boolean deleteById(UUID id);

}
