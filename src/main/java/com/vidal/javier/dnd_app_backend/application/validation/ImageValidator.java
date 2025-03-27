package com.vidal.javier.dnd_app_backend.application.validation;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.vidal.javier.dnd_app_backend.application.exception.ValidationException;
import com.vidal.javier.dnd_app_backend.domain.exception.BadRequestException;

@Component
public class ImageValidator {

    private static final List<String> VALID_IMAGE_MIME_TYPES = List.of("image/apng", "image/avif", "image/gif",
            "image/jpeg", "image/png", "image/svg+xml", "image/webp");
    private static final long MAX_AVATAR_SIZE = 5 * 1024 * 1024;

    public void validate(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new BadRequestException("Avatar image cannot be empty.");
        }

        if (!VALID_IMAGE_MIME_TYPES.contains(file.getContentType())) {
            throw new ValidationException("Invalid avatar extension.");
        }

        if (file.getSize() > MAX_AVATAR_SIZE) {
            throw new ValidationException("Avatar image cannot exceed 5MB");
        }
    }
}
