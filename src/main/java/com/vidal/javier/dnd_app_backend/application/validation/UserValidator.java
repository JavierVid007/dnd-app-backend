package com.vidal.javier.dnd_app_backend.application.validation;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.vidal.javier.dnd_app_backend.domain.exception.InvalidEmailException;
import com.vidal.javier.dnd_app_backend.domain.exception.InvalidPasswordException;
import com.vidal.javier.dnd_app_backend.domain.exception.InvalidRoleException;
import com.vidal.javier.dnd_app_backend.domain.exception.InvalidUserDataException;
import com.vidal.javier.dnd_app_backend.domain.exception.InvalidUsernameException;
import com.vidal.javier.dnd_app_backend.domain.model.Role;

@Component
public class UserValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    private static final Pattern PASSWORD_PATTERN = Pattern
            .compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])[A-Za-z\\d\\W_]{8,}$");

    private final ImageValidator imageValidator;

    @Autowired
    public UserValidator(ImageValidator imageValidator) {
        this.imageValidator = imageValidator;
    }

    public void validate(
            String username,
            String email,
            String password,
            String firstName,
            String lastName,
            String bio,
            String role,
            MultipartFile avatar) {

        if (username == null || username.isBlank()) {
            throw new InvalidUsernameException("Username cannot be empty.");
        } else if (username.length() < 4) {
            throw new InvalidUsernameException("Username must have at least 4 characters.");
        } else if (username.length() > 20) {
            throw new InvalidUsernameException("Username can't have more than 20 characters.");
        }

        if (email == null || email.isBlank()) {
            throw new InvalidEmailException("Email cannot be empty.");
        } else if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new InvalidEmailException("Invalid email value.");
        }

        if (password == null || password.isBlank()) {
            throw new InvalidPasswordException("Password cannot be empty.");
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new InvalidPasswordException("Invalid password value.");
        }

        if (firstName != null && firstName.isBlank()) {
            throw new InvalidUserDataException("First name cannot be empty.");
        }
        if (lastName != null && lastName.isBlank()) {
            throw new InvalidUserDataException("Last name cannot be empty.");
        }
        if (bio != null && bio.length() > 500) {
            throw new InvalidUserDataException("Bio can't have more than 500 characters.");
        }

        if (role == null || role.isBlank()) {
            throw new InvalidRoleException("Role cannot be empty.");
        }
        try {
            Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidRoleException("Invalid role value.");
        }

        imageValidator.validate(avatar);
    }

}
