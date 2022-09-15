package com.poketrirx.marble.teamservice.teams.impl.services;

import java.util.Objects;

import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableList;
import io.astefanutti.metrics.aspectj.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.data.common.Hint;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.repositories.TeamRepository;
import com.poketrirx.marble.teamservice.teams.pub.services.TeamSearchService;

@Metrics
@Component
public class TeamSearchServiceImpl implements TeamSearchService {
    private final TeamRepository repository;

    @Autowired
    public TeamSearchServiceImpl(TeamRepository repository) {
        this.repository = Objects.requireNonNull(repository);
    }

    @Timed(name = "TeamGetAllService.get")
    public ImmutableList<Team> get(ImmutableList<Criterion> criteria, ImmutableList<Hint> hints) {
        Objects.requireNonNull(criteria);
        Objects.requireNonNull(hints);

        return repository.get(criteria, hints);
    }
}