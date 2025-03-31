package com.vidal.javier.dnd_app_backend.infrastructure.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponseDTO {

    public UserResponseDTO user;
    public String token;

}
