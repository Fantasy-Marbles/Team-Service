package com.poketrirx.marble.framework.exceptions;

public final class NotAuthorizedException extends BaseUserServiceException {
    public NotAuthorizedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotAuthorizedException(String message) {
        super(message);
    }
}
