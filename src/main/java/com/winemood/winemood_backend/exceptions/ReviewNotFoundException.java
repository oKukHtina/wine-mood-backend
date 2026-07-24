package com.winemood.winemood_backend.exceptions;

public class ReviewNotFoundException extends RuntimeException {

    public ReviewNotFoundException(Long reviewId) {
        super("Review with id " + reviewId + " not found");
    }
}
