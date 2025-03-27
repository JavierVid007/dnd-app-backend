package com.vidal.javier.dnd_app_backend.infrastructure.exception;

import com.vidal.javier.dnd_app_backend.domain.exception.JVGlobalException;

public class DatabaseException extends JVGlobalException {

    public DatabaseException(String message) {
        super(message);
    }

}
