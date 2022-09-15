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
import com.poketrirx.marble.framework.exceptions.InvalidResourceStateException;

@Log4j2
@ControllerAdvice
public final class InvalidResourceStateExceptionHandlingControllerAdvice extends BaseExceptionHandlingControllerAdvice<InvalidResourceStateException> {
    @ResponseBody
    @ExceptionHandler(InvalidResourceStateException.class)
    public ResponseEntity<ErrorData> execute(InvalidResourceStateException ex) {
        return getErrorData(ex);
    }

    @Override
    protected HttpStatus responseStatus(InvalidResourceStateException ex) {
        return HttpStatus.CONFLICT;
    }

    @Override
    protected Map<String, String> getData(InvalidResourceStateException ex) {
        return new HashMap<>();
    }
}