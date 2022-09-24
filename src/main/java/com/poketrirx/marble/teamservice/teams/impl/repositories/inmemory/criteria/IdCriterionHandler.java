package com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory.criteria;

import java.util.stream.Stream;

import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.data.inmemory.CriterionHandler;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.repositories.criteria.IdCriterion;

public final class IdCriterionHandler implements CriterionHandler<Team> {
    @Override
    public boolean canHandle(Criterion criterion) {
        return criterion instanceof IdCriterion;
    }

    @Override
    public Stream<Team> handle(Criterion criterion, Stream<Team> stream) {
        if (canHandle(criterion)) {
            IdCriterion idCriterion = (IdCriterion) criterion;

            return stream.filter(team -> team.getId().equalsIgnoreCase(idCriterion.getId()));
        }

        return stream;
    }
}
