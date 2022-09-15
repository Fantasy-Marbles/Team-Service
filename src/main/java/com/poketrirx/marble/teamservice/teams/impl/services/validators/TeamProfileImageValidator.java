package com.poketrirx.marble.teamservice.teams.impl.services.validators;

import com.poketrirx.marble.framework.validation.Validator;
import com.poketrirx.marble.framework.validation.ValidatorResultReason;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;

public final class TeamProfileImageValidator implements Validator<Team> {
    @Override
    public ValidatorResultReason isValid(Team team) {
        return ValidatorResultReason.builder()
                .isValid(true)
                .fieldName("profileImage")
                .reason(team.getProfileImage() + " is an invalid profile image")
                .build();
    }
}