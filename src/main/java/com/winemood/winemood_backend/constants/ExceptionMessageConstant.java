package com.winemood.winemood_backend.constants;

public final class ExceptionMessageConstant {
    public static final String INVALID_CREDENTIALS = "Invalid email or password";
    public static final String EXISTING_USER = "User already exists";
    public static final String USER_BY_EMAIL_NOT_FOUND = "Can't find user by email";
    public static final String FILE_UPLOAD_FAILED = "Failed to upload image";
    public static final String USER_NOT_FOUND = "User not found";
    public static final String FILE_DELETE_FAILED = "Failed to delete image";
    public static final String FILE_IS_EMPTY = "Image file is empty";
    public static final String UNSUPPORTED_IMAGE_TYPE =
            "Only JPEG, PNG and WebP images are allowed";
    public static final String FILE_TOO_LARGE =
            "Image size must not exceed 10 MB";

    private ExceptionMessageConstant() {
    }
}
