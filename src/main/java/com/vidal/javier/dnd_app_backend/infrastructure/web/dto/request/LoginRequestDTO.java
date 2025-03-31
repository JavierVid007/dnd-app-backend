package com.vidal.javier.dnd_app_backend.infrastructure.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginRequestDTO {

    private String identifier; // username || email
    private String password;

}
