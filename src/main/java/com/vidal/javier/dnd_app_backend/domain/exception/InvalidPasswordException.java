package com.vidal.javier.dnd_app_backend.domain.exception;

public class InvalidPasswordException extends InvalidUserDataException {

    public InvalidPasswordException(String message) {
        super("Invalid Password Exception: " + message);
    }

}
