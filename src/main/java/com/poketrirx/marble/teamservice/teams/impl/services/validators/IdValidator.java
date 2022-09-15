package com.poketrirx.marble.teamservice.teams.impl.services.validators;

import com.poketrirx.marble.framework.validation.Validator;
import com.poketrirx.marble.framework.validation.ValidatorResultReason;

public final class IdValidator implements Validator<String> {
    @Override
    public ValidatorResultReason isValid(String id) {
        ValidatorResultReason.ValidatorResultReasonBuilder builder = ValidatorResultReason.builder()
                .isValid(true)
                .fieldName("id");

        if (id == null || id.length() == 0) {
            builder
                    .isValid(false)
                    .reason("Id is invalid");
        }

        return builder.build();
    }
}