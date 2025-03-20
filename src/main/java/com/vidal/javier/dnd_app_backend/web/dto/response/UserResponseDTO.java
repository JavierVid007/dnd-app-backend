package com.vidal.javier.dnd_app_backend.web.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.vidal.javier.dnd_app_backend.domain.model.Role;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {

    private UUID id;
    private String username;

    private String firstName;
    private String lastName;
    private String bio;
    private Role role;
    private String avatarUrl;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime lastLogin;

    private List<CharacterResponseDTO> characters;
    private List<WorldResponseDTO> worlds;

}
