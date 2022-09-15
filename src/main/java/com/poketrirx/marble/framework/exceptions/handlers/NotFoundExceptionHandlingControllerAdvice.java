package com.poketrirx.marble.framework.exceptions.handlers;

import java.util.Map;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poketrirx.marble.framework.exceptions.errors.ErrorData;
import com.poketrirx.marble.framework.exceptions.NotFoundException;

@Log4j2
@ControllerAdvice
public final class NotFoundExceptionHandlingControllerAdvice extends BaseExceptionHandlingControllerAdvice<NotFoundException> {
    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorData> execute(NotFoundException ex) {
        log.info("Handling a NotFoundException", ex);

        return getErrorData(ex);
    }

    @Override
    protected HttpStatus responseStatus(NotFoundException ex) {
        return HttpStatus.NOT_FOUND;
    }

    @Override
    protected Map<String, String> getData(NotFoundException ex) {
        return Map.of(
            "resource", ex.getResource(),
            "resourceId", ex.getResourceId()
        );
    }
}