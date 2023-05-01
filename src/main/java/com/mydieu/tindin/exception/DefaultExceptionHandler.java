package com.mydieu.tindin.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiError handleResourceNotFoundException(
            ResourceNotFoundException exception,
            HttpServletRequest request
    ) {
        return new ApiError(
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage()
        );
    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ApiError handleDuplicateResourceException(
            DuplicateResourceException exception,
            HttpServletRequest request
    ) {
        return new ApiError(
                request.getRequestURI(),
                HttpStatus.CONFLICT.value(),
                exception.getMessage()
        );
    }

    @ExceptionHandler(InvalidRequestException.class)
    public ApiError handleInvalidRequestException(
            InvalidRequestException exception,
            HttpServletRequest request
    ) {
        return new ApiError(
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage()
        );
    }

    @ExceptionHandler(Exception.class)
    public ApiError handleException(
            Exception exception,
            HttpServletRequest request
    ) {
        return new ApiError(
                request.getRequestURI(),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage()
        );
    }
}
