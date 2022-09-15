package com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory.criteria;

import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.data.inmemory.CriterionHandler;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.repositories.criteria.IdsCriterion;

import java.util.stream.Stream;

public final class IdsCriterionHandler implements CriterionHandler<Team> {
    @Override
    public boolean canHandle(Criterion criterion) {
        return criterion instanceof IdsCriterion;
    }

    @Override
    public Stream<Team> handle(Criterion criterion, Stream<Team> stream) {
        if (canHandle(criterion)) {
            IdsCriterion idsCriterion = (IdsCriterion) criterion;

            return stream.filter(team -> idsCriterion.getIds().stream().anyMatch(id -> team.getId().equalsIgnoreCase(id)));
        }

        return stream;
    }
}
