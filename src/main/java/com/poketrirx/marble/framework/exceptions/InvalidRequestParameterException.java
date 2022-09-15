package com.poketrirx.marble.framework.exceptions;

public final class InvalidRequestParameterException extends BaseUserServiceException {
    public InvalidRequestParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidRequestParameterException(String message) {
        super(message);
    }
}
