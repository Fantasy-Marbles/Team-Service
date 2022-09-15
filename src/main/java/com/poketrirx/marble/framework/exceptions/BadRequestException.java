package com.poketrirx.marble.framework.exceptions;

public final class BadRequestException extends BaseUserServiceException {
    public BadRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public BadRequestException(String message) {
        super(message);
    }
}