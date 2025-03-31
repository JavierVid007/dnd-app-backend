package com.vidal.javier.dnd_app_backend.infrastructure.web.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vidal.javier.dnd_app_backend.infrastructure.web.dto.request.LoginRequestDTO;
import com.vidal.javier.dnd_app_backend.infrastructure.web.dto.request.RegisterRequestDTO;
import com.vidal.javier.dnd_app_backend.infrastructure.web.dto.response.AuthResponseDTO;
import com.vidal.javier.dnd_app_backend.infrastructure.web.dto.response.UserResponseDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@RequestBody RegisterRequestDTO request) {

        /**
         * 1. Obtener UserResponseDTO llamando al caso de uso para guardarlo.
         * 2. Crear URI location con este id.
         * 3. Devolver ResponseEntity<UserResponseDTO>
         */

        // Llamar al CASO DE USO DE REGISTRO
        UserResponseDTO response = new UserResponseDTO(null, null, null, null, null, null, null, null, null, null, null,
                null);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> register(@RequestBody LoginRequestDTO request) {

        /**
         * 1. Obtener AuthResponseDTO llamando al caso de uso para autenticarlo.
         * 2. Devolver ResponseEntity<AuthResponseDTO>
         */

        // Llamar al CASO DE USO DE LOGIN
        AuthResponseDTO response = new AuthResponseDTO(null, null);

        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<String> refreshToken(@RequestHeader("Authorization") String refreshToken) {

        /**
         * 1. Obtener Token llamando al caso de uso para refrescar token.
         * 2. Devolver ResponseEntity<String>
         */

        // Llamar al CASO DE USO DE REFRESH TOKEN
        String accessToken = "";

        return ResponseEntity.ok().body(accessToken);
    }

    // @PostMapping("/logout") ?
    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestBody String refreshToken) {

        /**
         * 1. Invalidar Token
         * 2. Devolver ResponseEntity<String>
         */

        return ResponseEntity.ok().body("Logged out successfuly");
    }

}
