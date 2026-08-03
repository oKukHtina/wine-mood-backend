package com.winemood.winemood_backend.exceptions;

public class AchievementNotFoundException extends RuntimeException {
    public AchievementNotFoundException(String code) {
        super("Achievement not found: " + code);
    }
}
