package com.logdbmanag.exception.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class FunctionalityNotAvailableException extends RuntimeException {
    public FunctionalityNotAvailableException(String message) {
        super(message);
    }
}
