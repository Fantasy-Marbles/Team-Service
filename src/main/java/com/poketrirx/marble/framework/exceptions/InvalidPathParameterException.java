package com.poketrirx.marble.framework.exceptions;

import lombok.Getter;

public final class InvalidPathParameterException extends BaseUserServiceException {
    @Getter
    private final String pathParameterName;

    public InvalidPathParameterException(String pathParameterName, String message, Throwable cause) {
        super(message, cause);

        this.pathParameterName = pathParameterName;
    }

    public InvalidPathParameterException(String pathParameterName, String message) {
        super(message);

        this.pathParameterName = pathParameterName;
    }
}