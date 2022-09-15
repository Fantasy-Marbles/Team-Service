package com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory.hints;

import java.util.Comparator;
import java.util.stream.Stream;

import com.poketrirx.marble.framework.data.common.Hint;
import com.poketrirx.marble.framework.data.inmemory.HintHandler;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.repositories.hints.SortHint;

import static java.util.Comparator.comparing;

public final class SortHintHandler implements HintHandler<Team> {
    @Override
    public boolean canHandle(Hint hint) {
        return hint instanceof SortHint;
    }

    @Override
    public Stream<Team> handle(Hint hint, Stream<Team> stream) {
        if (canHandle(hint)) {
            SortHint sortHint = (SortHint) hint;

            Comparator<Team> comparer = comparing((team) ->
                switch (sortHint.getField()) {
                    case "league" -> team.getLeagueId();
                    case "name" -> team.getName();
                    case "city" -> team.getCity();
                    default -> team.getId();
                }
            );

            return sortHint.isAscending() ?
                stream.sorted(comparer):
                stream.sorted(comparer.reversed());
        }

        return stream;
    }
}
