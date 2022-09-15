package com.poketrirx.marble.teamservice.teams.impl.services;

import java.util.Objects;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableList;
import io.astefanutti.metrics.aspectj.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poketrirx.marble.framework.validation.ValidationProcessor;
import com.poketrirx.marble.teamservice.teams.impl.services.validators.IdValidator;
import com.poketrirx.marble.teamservice.teams.pub.repositories.TeamRepository;
import com.poketrirx.marble.teamservice.teams.pub.repositories.criteria.IdCriterion;
import com.poketrirx.marble.teamservice.teams.pub.services.TeamDeleteService;

@Metrics
@Component
public class TeamDeleteServiceImpl implements TeamDeleteService {
    private final TeamRepository repository;
    private final ValidationProcessor<String> validator;

    @Autowired
    public TeamDeleteServiceImpl(TeamRepository repository) {
        this.repository = Objects.requireNonNull(repository);

        this.validator =
                ValidationProcessor.<String>builder()
                        .validator(new IdValidator())
                        .build();
    }

    @Timed(name = "TeamDeleteService.delete")
    public void delete(String id) {
        Objects.requireNonNull(id);

        validator.validate(id);

        repository.delete(ImmutableList.of(IdCriterion.builder().id(id).build()), ImmutableList.of());
    }
}