package com.logdbmanag.exception.exceptions;

import lombok.experimental.StandardException;

/**
 * Exception that we get when we send request(for e.x. to findById) and there is
 * no record with this id, then we get {@link NotFoundException}.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
@StandardException
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}