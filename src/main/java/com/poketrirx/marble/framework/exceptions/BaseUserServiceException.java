package com.poketrirx.marble.framework.exceptions;

public abstract class BaseUserServiceException extends RuntimeException {
    protected BaseUserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    protected BaseUserServiceException(String message) {
        super(message);
    }
}