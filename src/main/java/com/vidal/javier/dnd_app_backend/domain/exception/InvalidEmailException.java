package com.vidal.javier.dnd_app_backend.domain.exception;

public class InvalidEmailException extends InvalidUserDataException {

    public InvalidEmailException(String message) {
        super("Invalid Email Exception: " + message);
    }

}
