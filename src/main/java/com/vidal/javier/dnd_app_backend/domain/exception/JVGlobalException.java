package com.vidal.javier.dnd_app_backend.domain.exception;

public class JVGlobalException extends RuntimeException {

    public JVGlobalException(String message) {
        super(message);
    }

    public JVGlobalException(String message, Throwable cause) {
        super(message, cause);
    }

}
