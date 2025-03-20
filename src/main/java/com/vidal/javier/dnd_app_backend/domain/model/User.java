package com.vidal.javier.dnd_app_backend.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {

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

    private List<Character> characters;
    private List<World> worlds;

}
