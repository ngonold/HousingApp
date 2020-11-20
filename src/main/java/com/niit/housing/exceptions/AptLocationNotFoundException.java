package com.niit.housing.exceptions;

public class AptLocationNotFoundException extends RuntimeException {
    public AptLocationNotFoundException(String message) {
        super(message);
    }
}
