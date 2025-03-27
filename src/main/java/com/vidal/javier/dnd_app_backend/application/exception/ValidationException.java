package com.vidal.javier.dnd_app_backend.application.exception;

import com.vidal.javier.dnd_app_backend.domain.exception.JVGlobalException;

public class ValidationException extends JVGlobalException {

    public ValidationException(String message) {
        super(message);
    }

}
