package com.niit.housing.exceptions;

public class ApartmentNotFoundException extends RuntimeException {
    public ApartmentNotFoundException(String msg) {
        super(msg);
    }
}
