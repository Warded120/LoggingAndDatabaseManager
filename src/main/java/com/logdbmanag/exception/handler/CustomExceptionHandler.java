package com.logdbmanag.exception.handler;

import com.logdbmanag.exception.exceptions.BadRequestException;
import com.logdbmanag.exception.exceptions.BadSecretKeyException;
import com.logdbmanag.exception.exceptions.FileReadException;
import com.logdbmanag.exception.exceptions.FunctionalityNotAvailableException;
import com.logdbmanag.exception.exceptions.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.HashMap;
import java.util.Map;

/**
 * Custom exception handler.
 */
@AllArgsConstructor
@RestControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private ErrorAttributes errorAttributes;

    private Map<String, Object> getErrorAttributes(WebRequest webRequest) {
        return new HashMap<>(errorAttributes.getErrorAttributes(webRequest,
                ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE)));
    }

    /**
     * Method interceptor for BadRequest-related exceptions such as
     * {@link BadRequestException}
     *
     * @param request Contains details about the occurred exception.
     * @return ResponseEntity which contains the HTTP status and body with the
     *         message of the exception.
     * @author Nazar Prots
     */
    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handleBadRequestException(BadRequestException ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(getErrorAttributes(request));
        log.trace(ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }

    /**
     * Method interceptor exception {@link NotFoundException},
     *
     * @param request contain detail about occur exception.
     * @return ResponseEntity which contain http status and body with message of
     *         exception.
     * @author Nazar Prots
     */
    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleNotFoundException(WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(getErrorAttributes(request));
        log.trace(exceptionResponse.getMessage(), exceptionResponse.getTrace());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    /**
     * Method intercepts exception {@link FileReadException}.
     *
     * @param ex      Exception that should be intercepted.
     * @param request Contains details about the occurred exception.
     * @return {@code ResponseEntity} which contains the HTTP status and body with
     *         the exception message.
     */
    @ExceptionHandler(FileReadException.class)
    public final ResponseEntity<Object> handleFileReadException(FileReadException ex,
        WebRequest request) {
        log.error(ex.getMessage(), ex);

        ExceptionResponse exceptionResponse = new ExceptionResponse(getErrorAttributes(request));
        exceptionResponse.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(exceptionResponse);
    }

    /**
     * Method intercepts exception {@link BadSecretKeyException}.
     *
     * @param ex      Exception that should be intercepted.
     * @param request Contains details about the occurred exception.
     * @return {@code ResponseEntity} which contains the HTTP status and body with
     *         the exception message.
     */
    @ExceptionHandler(BadSecretKeyException.class)
    public final ResponseEntity<Object> handleBadSecretKeyException(BadSecretKeyException ex,
        WebRequest request) {
        log.error(ex.getMessage(), ex);

        ExceptionResponse exceptionResponse = new ExceptionResponse(getErrorAttributes(request));
        exceptionResponse.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionResponse);
    }

    @ExceptionHandler(FunctionalityNotAvailableException.class)
    public final ResponseEntity<Object> handleFunctionalityNotAvailableException(FunctionalityNotAvailableException ex,
        WebRequest request) {
        log.error(ex.getMessage(), ex);

        ExceptionResponse exceptionResponse = new ExceptionResponse(getErrorAttributes(request));
        exceptionResponse.setMessage(ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionResponse);
    }
}
