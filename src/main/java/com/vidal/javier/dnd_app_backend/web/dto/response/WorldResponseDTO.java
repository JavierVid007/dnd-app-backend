package com.vidal.javier.dnd_app_backend.web.dto.response;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WorldResponseDTO {

    private UUID id;
    private String name;

}
