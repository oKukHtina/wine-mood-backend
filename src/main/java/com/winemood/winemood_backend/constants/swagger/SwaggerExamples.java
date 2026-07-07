package com.winemood.winemood_backend.constants.swagger;

public final class SwaggerExamples {

    private SwaggerExamples() {
    }

    public static final String ERROR_400_VALIDATION = """
            {
              "timestamp": "2026-07-07T15:30:00",
              "status": 400,
              "error": "Bad Request",
              "message": "Validation failed",
              "path": "/api/auth/registration",
              "fieldErrors": [
                {
                  "field": "email",
                  "message": "Email must be valid"
                },
                {
                  "field": "password",
                  "message": "Password must contain at least one uppercase letter, one lowercase letter and one digit"
                }
              ]
            }
            """;

    public static final String ERROR_409_USER_ALREADY_EXISTS = """
            {
              "timestamp": "2026-07-07T15:30:00",
              "status": 409,
              "error": "Conflict",
              "message": "User already exists",
              "path": "/api/auth/registration"
            }
            """;
}
