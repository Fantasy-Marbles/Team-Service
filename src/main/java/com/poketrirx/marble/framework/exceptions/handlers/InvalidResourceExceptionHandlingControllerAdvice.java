package com.poketrirx.marble.framework.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poketrirx.marble.framework.exceptions.errors.ErrorData;
import com.poketrirx.marble.framework.exceptions.InvalidResourceException;

@Log4j2
@ControllerAdvice
public final class InvalidResourceExceptionHandlingControllerAdvice extends BaseExceptionHandlingControllerAdvice<InvalidResourceException> {
    @ResponseBody
    @ExceptionHandler(InvalidResourceException.class)
    public ResponseEntity<ErrorData> execute(InvalidResourceException ex) {
        return getErrorData(ex);
    }

    @Override
    protected HttpStatus responseStatus(InvalidResourceException ex) {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    protected Map<String, String> getData(InvalidResourceException ex) {
        return new HashMap<>();
    }
}