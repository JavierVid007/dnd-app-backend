package com.vidal.javier.dnd_app_backend.web.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangePasswordRequestDTO {

    private String currentPassword;
    private String newPassword;

}
