package com.poketrirx.marble.framework.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poketrirx.marble.framework.exceptions.InvalidRequestBodyException;
import com.poketrirx.marble.framework.exceptions.errors.ErrorData;

@Log4j2
@ControllerAdvice
public final class InvalidRequestBodyExceptionHandlingControllerAdvice extends BaseExceptionHandlingControllerAdvice<InvalidRequestBodyException> {
    @ResponseBody
    @ExceptionHandler(InvalidRequestBodyException.class)
    public ResponseEntity<ErrorData> execute(InvalidRequestBodyException ex) {
        return getErrorData(ex);
    }

    @Override
    protected HttpStatus responseStatus(InvalidRequestBodyException ex) {
        return HttpStatus.BAD_REQUEST;
    }

    @Override
    protected Map<String, String> getData(InvalidRequestBodyException ex) {
        return new HashMap<>();
    }
}