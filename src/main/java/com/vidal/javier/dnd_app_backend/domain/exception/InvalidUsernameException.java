package com.vidal.javier.dnd_app_backend.domain.exception;

public class InvalidUsernameException extends InvalidUserDataException {

    public InvalidUsernameException(String message) {
        super("Invalid Username Exception: " + message);
    }

}
