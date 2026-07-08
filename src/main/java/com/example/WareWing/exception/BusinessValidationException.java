package com.example.WareWing.exception;

public class BusinessValidationException
        extends RuntimeException {

    public BusinessValidationException(
            String message) {
        super(message);
    }
}