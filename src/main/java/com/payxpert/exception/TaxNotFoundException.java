package com.payxpert.exception;

public class TaxNotFoundException extends RuntimeException {
    public TaxNotFoundException(String message) {
        super(message);
    }
}
