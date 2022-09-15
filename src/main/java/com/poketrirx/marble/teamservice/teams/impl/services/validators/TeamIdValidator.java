package com.poketrirx.marble.teamservice.teams.impl.services.validators;

import com.poketrirx.marble.framework.validation.Validator;
import com.poketrirx.marble.framework.validation.ValidatorResultReason;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;

public final class TeamIdValidator implements Validator<Team> {
    private final Validator<String> idValidator;

    public TeamIdValidator() {
        idValidator = new IdValidator();
    }

    @Override
    public ValidatorResultReason isValid(Team team) {
        return idValidator.isValid(team.getId());
    }
}