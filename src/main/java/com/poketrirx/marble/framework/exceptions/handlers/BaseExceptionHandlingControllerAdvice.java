package com.poketrirx.marble.framework.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.poketrirx.marble.framework.exceptions.BaseUserServiceException;
import com.poketrirx.marble.framework.exceptions.errors.ErrorData;

public abstract class BaseExceptionHandlingControllerAdvice<TException extends BaseUserServiceException> {
    protected final ResponseEntity<ErrorData> getErrorData(TException ex) {
        return new ResponseEntity<>(
                ErrorData.builder()
                        .title(title(ex))
                        .message(message(ex))
                        .statusCode(statusCode(ex))
                        .data(getData(ex))
                        .build(),
                responseStatus(ex)
        );
    }

    protected String title(TException ex) {
        return responseStatus(ex).getReasonPhrase();
    }

    protected String message(TException ex) {
        return ex.getMessage();
    }

    protected int statusCode(TException ex) {
        return responseStatus(ex).value();
    }

    protected Map<String, String> getData(TException ex) {
        return new HashMap<>();
    }

    protected abstract HttpStatus responseStatus(TException ex);
}