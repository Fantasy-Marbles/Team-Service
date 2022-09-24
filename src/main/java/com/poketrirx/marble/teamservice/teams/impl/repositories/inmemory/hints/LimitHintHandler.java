package com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory.hints;

import java.util.stream.Stream;

import com.poketrirx.marble.framework.data.common.Hint;
import com.poketrirx.marble.framework.data.inmemory.HintHandler;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.repositories.hints.LimitHint;

public final class LimitHintHandler implements HintHandler<Team> {
    @Override
    public boolean canHandle(Hint hint) {
        return hint instanceof LimitHint;
    }

    @Override
    public Stream<Team> handle(Hint hint, Stream<Team> stream) {
        if (canHandle(hint)) {
            LimitHint limitHint = (LimitHint) hint;

            return stream.limit(limitHint.getCount());
        }

        return stream;
    }
}
