package com.vidal.javier.dnd_app_backend.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequestDTO {

    private String username;
    private String email;
    private String password;

}
