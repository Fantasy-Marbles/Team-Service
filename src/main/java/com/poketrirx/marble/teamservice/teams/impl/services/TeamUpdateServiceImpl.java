package com.poketrirx.marble.teamservice.teams.impl.services;

import java.util.Objects;

import com.codahale.metrics.annotation.Timed;
import io.astefanutti.metrics.aspectj.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poketrirx.marble.framework.validation.ValidationProcessor;
import com.poketrirx.marble.teamservice.teams.impl.services.validators.TeamIdValidator;
import com.poketrirx.marble.teamservice.teams.impl.services.validators.TeamNameValidator;
import com.poketrirx.marble.teamservice.teams.impl.services.validators.TeamProfileImageValidator;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.repositories.TeamRepository;
import com.poketrirx.marble.teamservice.teams.pub.services.TeamUpdateService;

@Metrics
@Component
public class TeamUpdateServiceImpl implements TeamUpdateService {
    private final TeamRepository repository;
    private final ValidationProcessor<Team> validator;

    @Autowired
    public TeamUpdateServiceImpl(TeamRepository repository) {
        this.repository = Objects.requireNonNull(repository);

        this.validator =
                ValidationProcessor.<Team>builder()
                        .validator(new TeamIdValidator())
                        .validator(new TeamNameValidator())
                        .validator(new TeamProfileImageValidator())
                        .build();
    }

    @Timed(name = "TeamService.update")
    public Team update(Team entity) {
        Objects.requireNonNull(entity);

        validator.getValidationResults(entity);

        return repository.update(entity);
    }
}