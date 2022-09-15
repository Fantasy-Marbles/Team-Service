package com.poketrirx.marble.teamservice.teams.impl.services.validators;

import com.poketrirx.marble.framework.validation.Validator;
import com.poketrirx.marble.framework.validation.ValidatorResultReason;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;

public final class TeamNameValidator implements Validator<Team> {
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 100;
    private static final String FIELD_NAME = "name";

    @Override
    public ValidatorResultReason isValid(Team team) {
        ValidatorResultReason.ValidatorResultReasonBuilder builder = ValidatorResultReason.builder()
                .fieldName(FIELD_NAME)
                .isValid(true);

        if (team.getName().length() < MIN_LENGTH) {
            builder
                    .isValid(false)
                    .reason("Must be longer than " + (MIN_LENGTH - 1) + " character");
        } else if (team.getName().length() > MAX_LENGTH) {
            builder
                    .isValid(false)
                    .reason("Cannot be longer than " + MAX_LENGTH + " characters");
        }

        return builder.build();
    }
}