package com.poketrirx.marble.teamservice.teams.impl.services;

import java.util.Objects;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableList;
import io.astefanutti.metrics.aspectj.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.data.common.Hint;
import com.poketrirx.marble.framework.exceptions.NotFoundException;
import com.poketrirx.marble.framework.validation.ValidationProcessor;
import com.poketrirx.marble.teamservice.teams.impl.services.validators.IdValidator;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.repositories.TeamRepository;
import com.poketrirx.marble.teamservice.teams.pub.repositories.criteria.IdCriterion;
import com.poketrirx.marble.teamservice.teams.pub.services.TeamGetByIdService;

@Metrics
@Component
public class TeamGetByIdServiceImpl implements TeamGetByIdService {
    private static final ImmutableList<Hint> HINTS = ImmutableList.of();

    private final TeamRepository repository;
    private final ValidationProcessor<String> validator;

    @Autowired
    public TeamGetByIdServiceImpl(TeamRepository repository) {
        this.repository = Objects.requireNonNull(repository);

        this.validator =
                ValidationProcessor.<String>builder()
                        .validator(new IdValidator())
                        .build();
    }

    @Timed(name = "TeamGetByIdService.get")
    public Team get(String id) {
        Objects.requireNonNull(id);

        validator.validate(id);

        ImmutableList<Team> teams = repository.get(getCriteria(id), HINTS);

        return unwrap(id, teams);
    }

    private static ImmutableList<Criterion> getCriteria(String id) {
        return ImmutableList.of(IdCriterion.builder().id(id).build());
    }

    private static Team unwrap(String id, ImmutableList<Team> teams) {
        if (teams.size() == 0) {
            throw new NotFoundException("Could not find team with id: " + id, "Team", id);
        }

        return teams.get(0);
    }
}