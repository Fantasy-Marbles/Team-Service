package com.poketrirx.marble.framework.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.poketrirx.marble.framework.exceptions.handlers.BadRequestExceptionHandlingControllerAdvice;
import com.poketrirx.marble.framework.exceptions.handlers.ForbiddenExceptionHandlingControllerAdvice;
import com.poketrirx.marble.framework.exceptions.handlers.InvalidPathParameterExceptionHandlingControllerAdvice;
import com.poketrirx.marble.framework.exceptions.handlers.InvalidRequestBodyExceptionHandlingControllerAdvice;
import com.poketrirx.marble.framework.exceptions.handlers.InvalidRequestParameterExceptionHandlingControllerAdvice;
import com.poketrirx.marble.framework.exceptions.handlers.InvalidResourceExceptionHandlingControllerAdvice;
import com.poketrirx.marble.framework.exceptions.handlers.InvalidResourceStateExceptionHandlingControllerAdvice;
import com.poketrirx.marble.framework.exceptions.handlers.NotAuthorizedExceptionHandlingControllerAdvice;
import com.poketrirx.marble.framework.exceptions.handlers.NotFoundExceptionHandlingControllerAdvice;

@Import({
        BadRequestExceptionHandlingControllerAdvice.class,
        ForbiddenExceptionHandlingControllerAdvice.class,
        InvalidPathParameterExceptionHandlingControllerAdvice.class,
        InvalidRequestBodyExceptionHandlingControllerAdvice.class,
        InvalidRequestParameterExceptionHandlingControllerAdvice.class,
        InvalidResourceExceptionHandlingControllerAdvice.class,
        InvalidResourceStateExceptionHandlingControllerAdvice.class,
        NotAuthorizedExceptionHandlingControllerAdvice.class,
        NotFoundExceptionHandlingControllerAdvice.class
})
@Configuration
public class MarbleFrameworkConfig {}