package com.poketrirx.marble.framework.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poketrirx.marble.framework.exceptions.NotAuthorizedException;
import com.poketrirx.marble.framework.exceptions.errors.ErrorData;

@Log4j2
@ControllerAdvice
public final class NotAuthorizedExceptionHandlingControllerAdvice extends BaseExceptionHandlingControllerAdvice<NotAuthorizedException> {
    @ResponseBody
    @ExceptionHandler(NotAuthorizedException.class)
    public ResponseEntity<ErrorData> execute(NotAuthorizedException ex) {
        return getErrorData(ex);
    }

    @Override
    protected HttpStatus responseStatus(NotAuthorizedException ex) {
        return HttpStatus.UNAUTHORIZED;
    }

    @Override
    protected Map<String, String> getData(NotAuthorizedException ex) {
        return new HashMap<>();
    }
}