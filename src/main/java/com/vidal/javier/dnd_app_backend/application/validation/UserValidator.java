package com.vidal.javier.dnd_app_backend.application.validation;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.vidal.javier.dnd_app_backend.application.exception.ValidationException;
import com.vidal.javier.dnd_app_backend.domain.exception.BadRequestException;
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
            throw new BadRequestException("Username cannot be empty.");
        } else if (username.length() < 4) {
            throw new ValidationException("Username must have at least 4 characters.");
        } else if (username.length() > 20) {
            throw new ValidationException("Username can't have more than 20 characters.");
        }

        if (email == null || email.isBlank()) {
            throw new BadRequestException("Email cannot be empty.");
        } else if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new BadRequestException("Invalid email value.");
        }

        if (password == null || password.isBlank()) {
            throw new BadRequestException("Password cannot be empty.");
        } else if (!PASSWORD_PATTERN.matcher(password).matches()) {
            throw new ValidationException("Invalid password value.");
        }

        if (firstName != null && firstName.isBlank()) {
            throw new BadRequestException("First name cannot be empty.");
        }
        if (lastName != null && lastName.isBlank()) {
            throw new BadRequestException("Last name cannot be empty.");
        }
        if (bio != null && bio.length() > 500) {
            throw new BadRequestException("Bio can't have more than 500 characters.");
        }

        if (role == null || role.isBlank()) {
            throw new BadRequestException("Role cannot be empty.");
        }
        try {
            Role.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid role value.");
        }

        imageValidator.validate(avatar);
    }

}
