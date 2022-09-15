package com.poketrirx.marble.teamservice.teams.impl.repositories;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public final class CriteriaDataBindingControllerAdvice {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
    }
}