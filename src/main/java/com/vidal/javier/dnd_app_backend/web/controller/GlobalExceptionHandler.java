package com.vidal.javier.dnd_app_backend.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vidal.javier.dnd_app_backend.application.exception.ValidationException;
import com.vidal.javier.dnd_app_backend.domain.exception.AuthorizationException;
import com.vidal.javier.dnd_app_backend.domain.exception.BadRequestException;
import com.vidal.javier.dnd_app_backend.domain.exception.ConflictException;
import com.vidal.javier.dnd_app_backend.domain.exception.ForbiddenException;
import com.vidal.javier.dnd_app_backend.domain.exception.NotFoundException;
import com.vidal.javier.dnd_app_backend.infrastructure.exception.DatabaseException;
import com.vidal.javier.dnd_app_backend.infrastructure.exception.JwtAuthenticationException;
import com.vidal.javier.dnd_app_backend.infrastructure.exception.StorageException;
import com.vidal.javier.dnd_app_backend.web.dto.response.ErrorResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ BadRequestException.class, ValidationException.class })
    public ResponseEntity<ErrorResponseDTO> handleBadRequestException(RuntimeException e) {
        return buildResponse(HttpStatus.BAD_REQUEST, e.getMessage()); // 400
    }

    @ExceptionHandler({ AuthorizationException.class, JwtAuthenticationException.class })
    public ResponseEntity<ErrorResponseDTO> handleAuthorizationException(RuntimeException e) {
        return buildResponse(HttpStatus.UNAUTHORIZED, e.getMessage()); // 401
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorResponseDTO> handleForbiddenException(ForbiddenException e) {
        return buildResponse(HttpStatus.FORBIDDEN, e.getMessage()); // 403
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleNotFoundException(NotFoundException e) {
        return buildResponse(HttpStatus.NOT_FOUND, e.getMessage()); // 404
    }

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorResponseDTO> handleConflictException(ConflictException e) {
        return buildResponse(HttpStatus.CONFLICT, e.getMessage()); // 409
    }

    @ExceptionHandler({ DatabaseException.class, StorageException.class })
    public ResponseEntity<ErrorResponseDTO> handleDatabaseException(RuntimeException e) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error occurred."); // 500
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleGenericException(Exception e) {
        return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error occurred."); // 500
    }

    private ResponseEntity<ErrorResponseDTO> buildResponse(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(new ErrorResponseDTO(status.value(), message));
    }

}
