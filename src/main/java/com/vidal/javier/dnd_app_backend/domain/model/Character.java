package com.vidal.javier.dnd_app_backend.domain.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Character {

    private UUID id;
    private String name;

    private User user;

}
