package com.logdbmanag.exception.exceptions;

import lombok.experimental.StandardException;

@StandardException
public class FileReadException extends RuntimeException {
    public FileReadException(String message) {
        super(message);
    }
}
