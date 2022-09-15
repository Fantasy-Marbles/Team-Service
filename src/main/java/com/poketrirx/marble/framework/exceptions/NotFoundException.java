package com.poketrirx.marble.framework.exceptions;

import lombok.Getter;

public final class NotFoundException extends BaseUserServiceException {
    @Getter
    private final String resource;
    @Getter
    private final String resourceId;

    public NotFoundException(String message, String resource, String resourceId, Throwable cause) {
        super(message, cause);

        this.resource = resource;
        this.resourceId = resourceId;
    }

    public NotFoundException(String message, String resource, String resourceId) {
        super(message);

        this.resource = resource;
        this.resourceId = resourceId;
    }
}
