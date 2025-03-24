package com.vidal.javier.dnd_app_backend.domain.exception;

public class InvalidRoleException extends InvalidUserDataException {

    public InvalidRoleException(String message) {
        super("Invalid Role Exception:" + message);
    }

}
