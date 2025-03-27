package com.vidal.javier.dnd_app_backend.infrastructure.exception;

import com.vidal.javier.dnd_app_backend.domain.exception.JVGlobalException;

public class JwtAuthenticationException extends JVGlobalException {

    public JwtAuthenticationException(String message) {
        super(message);
    }

}
