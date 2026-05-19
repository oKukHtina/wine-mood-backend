package com.winemood.winemood_backend.exceptions;

public class WineNotFoundException extends RuntimeException {
    public WineNotFoundException(Long id) {
        super("Wine was not found with id: " + id);
    }
}
