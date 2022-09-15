package com.poketrirx.marble.framework.exceptions;

public final class InvalidResourceException extends BaseUserServiceException {
    public InvalidResourceException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidResourceException(String message) {
        super(message);
    }
}
