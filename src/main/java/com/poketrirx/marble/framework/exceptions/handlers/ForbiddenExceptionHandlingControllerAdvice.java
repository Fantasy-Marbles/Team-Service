package com.poketrirx.marble.framework.exceptions.handlers;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poketrirx.marble.framework.exceptions.ForbiddenException;
import com.poketrirx.marble.framework.exceptions.errors.ErrorData;

@Log4j2
@ControllerAdvice
public final class ForbiddenExceptionHandlingControllerAdvice extends BaseExceptionHandlingControllerAdvice<ForbiddenException> {
    @ResponseBody
    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorData> execute(ForbiddenException ex) {
        return getErrorData(ex);
    }

    @Override
    protected HttpStatus responseStatus(ForbiddenException ex) {
        return HttpStatus.FORBIDDEN;
    }

    @Override
    protected Map<String, String> getData(ForbiddenException ex) {
        return new HashMap<>();
    }
}