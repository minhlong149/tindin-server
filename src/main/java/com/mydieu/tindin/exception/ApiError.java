package com.mydieu.tindin.exception;

import java.time.LocalDateTime;

public record ApiError(
        String path,
        int status,
        String message,
        LocalDateTime timestamp
) {
    public ApiError(String path, int status, String message) {
        this(path, status, message, LocalDateTime.now());
    }
}
