package com.vidal.javier.dnd_app_backend.infrastructure.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vidal.javier.dnd_app_backend.infrastructure.web.dto.request.ChangePasswordRequestDTO;
import com.vidal.javier.dnd_app_backend.infrastructure.web.dto.request.LoginRequestDTO;
import com.vidal.javier.dnd_app_backend.infrastructure.web.dto.response.UserResponseDTO;

@RestController
@RequestMapping("/api/users/me")
public class AccountController {

    @GetMapping
    public ResponseEntity<UserResponseDTO> getUser(@RequestHeader("Authorization") String token) {

        /**
         * 1. Obtener UserResponseDTO llamando al caso de uso para obtenerlo.
         * 2. Devolver ResponseEntity<UserResponseDTO>
         */

        // Llamar al CASO DE USO DE OBTENCIÓN
        UserResponseDTO user = new UserResponseDTO(null, null, null, null, null, null, null, null, null, null, null,
                null);

        return ResponseEntity.ok().body(user);
    }

    @PutMapping
    public ResponseEntity<UserResponseDTO> updateUser(@RequestHeader("Authorization") String token,
            @RequestBody LoginRequestDTO request) {

        /**
         * 1. Obtener UserResponseDTO llamando al caso de uso para actualizarlo.
         * 2. Devolver ResponseEntity<UserResponseDTO>
         */

        UserResponseDTO user = new UserResponseDTO(null, null, null, null, null, null, null, null, null, null, null,
                null);

        return ResponseEntity.ok().body(user);
    }

    @PatchMapping("/password")
    public ResponseEntity<String> changePassword(@RequestHeader("Authorization") String token,
            @RequestBody ChangePasswordRequestDTO request) {

        /**
         * 1. Cambiar contraseña con el caso de uso para cambiarla.
         * 2. Devolver ResponseEntity<String>
         */

        return ResponseEntity.ok().body("Password updated successfully");
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUser(@RequestHeader("Authorization") String token) {

        /**
         * 1. Borrar usuario con el caso de uso para borrarlo.
         * 2. Devolver ResponseEntity<String>
         */

        return ResponseEntity.ok().body("User account deleted successfully");
    }

}
