package com.logdbmanag.exception.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class BadSecretKeyException extends RuntimeException {
    public BadSecretKeyException(String message) {
        super(message);
    }
}
