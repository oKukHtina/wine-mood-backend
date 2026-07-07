package com.winemood.winemood_backend.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final LocalDateTime timestamp;
    private final int status;
    private final String error;
    private final String message;
    private final String path;

    private final List<FieldValidationError> fieldErrors;

    public ErrorResponse(
            int status,
            String error,
            String message,
            String path
    ) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fieldErrors = null;
    }

    public ErrorResponse(
            int status,
            String error,
            String message,
            String path,
            List<FieldValidationError> fieldErrors
    ) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fieldErrors = fieldErrors;
    }

    @Getter
    public static class FieldValidationError {
        private final String field;
        private final String message;

        public FieldValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }
    }
}
