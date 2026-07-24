package com.winemood.winemood_backend.exceptions;

public class ReviewAlreadyExistsException extends RuntimeException {
    public ReviewAlreadyExistsException() {
        super("Review for this wine already exists");
    }
}