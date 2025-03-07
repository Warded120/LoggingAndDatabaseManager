package com.logdbmanag.exception.exceptions;

import lombok.experimental.StandardException;

/**
 * Exception that we get when user trying to pass bad request.
 */
@StandardException
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
