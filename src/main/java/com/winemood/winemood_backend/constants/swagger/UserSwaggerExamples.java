package com.winemood.winemood_backend.constants.swagger;

public final class UserSwaggerExamples {

    public static final String ERROR_400_IMAGE_IS_EMPTY = """
            {
              "timestamp": "2026-07-15T20:15:00",
              "status": 400,
              "error": "Bad Request",
              "message": "Image file is empty",
              "path": "/api/users/avatar"
            }
            """;

    public static final String ERROR_400_UNSUPPORTED_IMAGE_TYPE = """
            {
              "timestamp": "2026-07-15T20:15:00",
              "status": 400,
              "error": "Bad Request",
              "message": "Only JPEG, PNG and WebP images are allowed",
              "path": "/api/users/avatar"
            }
            """;

    public static final String ERROR_400_IMAGE_TOO_LARGE = """
            {
              "timestamp": "2026-07-15T20:15:00",
              "status": 400,
              "error": "Bad Request",
              "message": "Image size must not exceed 10 MB",
              "path": "/api/users/avatar"
            }
            """;

    public static final String ERROR_403_ACCESS_DENIED = """
            {
              "timestamp": "2026-07-15T20:15:00",
              "status": 403,
              "error": "Forbidden",
              "message": "Access Denied",
              "path": "/api/users/avatar"
            }
            """;

    public static final String ERROR_500_IMAGE_UPLOAD_FAILED = """
            {
              "timestamp": "2026-07-15T20:15:00",
              "status": 500,
              "error": "Internal Server Error",
              "message": "Failed to upload image",
              "path": "/api/users/avatar"
            }
            """;

    public static final String ERROR_500_IMAGE_DELETE_FAILED = """
            {
              "timestamp": "2026-07-15T20:15:00",
              "status": 500,
              "error": "Internal Server Error",
              "message": "Failed to delete image",
              "path": "/api/users/avatar"
            }
            """;

    private UserSwaggerExamples() {
    }
}