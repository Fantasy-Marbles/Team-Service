package com.poketrirx.marble.framework.exceptions;

public final class InvalidResourceStateException extends BaseUserServiceException {
    public InvalidResourceStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidResourceStateException(String message) {
        super(message);
    }
}
