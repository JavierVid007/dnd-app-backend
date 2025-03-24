package com.vidal.javier.dnd_app_backend.infrastructure.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.vidal.javier.dnd_app_backend.domain.model.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String email;
    private String password;

    private String firstName;
    private String lastName;
    private String bio;
    private Role role;
    private String avatarUrl;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;

    @OneToMany(mappedBy = "userId")
    private List<CharacterEntity> characters;

    @OneToMany(mappedBy = "userId")
    private List<WorldEntity> worlds;

}
