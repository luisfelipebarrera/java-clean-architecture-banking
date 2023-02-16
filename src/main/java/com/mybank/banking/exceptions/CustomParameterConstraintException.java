package com.mybank.banking.exceptions;

public class CustomParameterConstraintException extends RuntimeException {
    public CustomParameterConstraintException() {
        super();
    }

    public CustomParameterConstraintException(String message) {
        super(message);
    }
}
