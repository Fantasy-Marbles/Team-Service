package com.poketrirx.marble.framework.exceptions;

public final class ForbiddenException extends BaseUserServiceException {
    public ForbiddenException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenException(String message) {
        super(message);
    }
}