package com.vidal.javier.dnd_app_backend.infrastructure.web.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidal.javier.dnd_app_backend.infrastructure.web.dto.response.UserResponseDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {

        /**
         * 1. Obtener lista de todos los usuarios con el caso de uso de obtención.
         * 2. Devolver ResponseEntity<List<UserResponseDTO>>
         */

        // Llamar al CASO DE USO DE OBTENCIÓN
        List<UserResponseDTO> users = null;

        return ResponseEntity.ok().body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getById(@PathVariable UUID id) {

        /**
         * 1. Obtener usuario con el caso de uso de obtención.
         * 2. Devolver ResponseEntity<UserResponseDTO>
         */

        // Llamar al CASO DE USO DE OBTENCIÓN
        UserResponseDTO user = new UserResponseDTO(null, null, null, null, null, null, null, null, null, null, null,
                null);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponseDTO> getByUsername(@PathVariable String username) {

        /**
         * 1. Obtener usuario con el caso de obtención.
         * 2. Devolver ResponseEntity<UserResponseDTO>
         */

        // Llamar al CASO DE USO DE OBTENCIÓN
        UserResponseDTO user = new UserResponseDTO(null, null, null, null, null, null, null, null,
                null, null, null, null);

        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getByEmail(@PathVariable String email) {

        /**
         * 1. Obtener usuario con el caso de obtención.
         * 2. Devolver ResponseEntity<UserResponseDTO>
         */

        // Llamar al CASO DE USO DE OBTENCIÓN
        UserResponseDTO user = new UserResponseDTO(null, null, null, null, null, null, null, null,
                null, null, null, null);

        return ResponseEntity.ok().body(user);
    }

}