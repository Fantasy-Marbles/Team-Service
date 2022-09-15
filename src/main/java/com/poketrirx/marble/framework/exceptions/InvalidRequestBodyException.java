package com.poketrirx.marble.framework.exceptions;

public final class InvalidRequestBodyException extends BaseUserServiceException {
    public InvalidRequestBodyException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRequestBodyException(String message) {
        super(message);
    }
}
