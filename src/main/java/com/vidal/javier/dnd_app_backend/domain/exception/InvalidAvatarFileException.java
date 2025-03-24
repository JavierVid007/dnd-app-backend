package com.vidal.javier.dnd_app_backend.domain.exception;

public class InvalidAvatarFileException extends InvalidUserDataException {

    public InvalidAvatarFileException(String message) {
        super("Invalid Avatar File Exception: " + message);
    }

}
