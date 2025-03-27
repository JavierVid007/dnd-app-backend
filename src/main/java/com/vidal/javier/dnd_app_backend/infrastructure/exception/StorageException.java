package com.vidal.javier.dnd_app_backend.infrastructure.exception;

import com.vidal.javier.dnd_app_backend.domain.exception.JVGlobalException;

public class StorageException extends JVGlobalException {

    public StorageException(String message) {
        super(message);
    }

}
