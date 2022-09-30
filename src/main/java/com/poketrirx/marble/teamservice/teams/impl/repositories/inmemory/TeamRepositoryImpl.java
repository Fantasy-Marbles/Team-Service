package com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.data.inmemory.InMemoryRepository;
import com.poketrirx.marble.framework.data.inmemory.CriteriaProcessor;
import com.poketrirx.marble.framework.data.inmemory.HintProcessor;
import com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory.criteria.IdCriterionHandler;
import com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory.criteria.IdsCriterionHandler;
import com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory.hints.LimitHintHandler;
import com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory.hints.PageHintHandler;
import com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory.hints.SortHintHandler;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.repositories.TeamRepository;
import com.poketrirx.marble.teamservice.teams.pub.repositories.criteria.IdCriterion;

@Component
public final class TeamRepositoryImpl extends InMemoryRepository<Team> implements TeamRepository {
    public TeamRepositoryImpl() {
        super();
    }

    @Override
    protected ImmutableList<Criterion> buildGetByIdCriteria(String id) {
        return ImmutableList.of(IdCriterion.builder().id(id).build());
    }

    @Override
    protected CriteriaProcessor<Team> buildCriteriaProcessor() {
        return CriteriaProcessor.<Team>builder()
                .handler(new IdCriterionHandler())
                .handler(new IdsCriterionHandler())
                .build();
    }

    @Override
    protected HintProcessor<Team> buildHintProcessor() {
        return HintProcessor.<Team>builder()
                .handler(new LimitHintHandler())
                .handler(new PageHintHandler())
                .handler(new SortHintHandler())
                .build();
    }

    @Override
    protected String getId(Team instance) {
        return instance.getId();
    }

    @Override
    protected Team cloneAndSetId(Team instance, String id) {
        return instance.toBuilder().id(id).build();
    }

    @Override
    protected Team clone(Team instance) {
        return instance.toBuilder().build();
    }
}