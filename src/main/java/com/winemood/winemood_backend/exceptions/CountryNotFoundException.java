package com.winemood.winemood_backend.exceptions;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(Long id) {
        super("Country was not found with id: " + id);
    }
}
