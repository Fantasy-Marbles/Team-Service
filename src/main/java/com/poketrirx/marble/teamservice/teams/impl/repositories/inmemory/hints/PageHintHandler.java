package com.poketrirx.marble.teamservice.teams.impl.repositories.inmemory.hints;

import java.util.stream.Stream;

import com.poketrirx.marble.framework.data.common.Hint;
import com.poketrirx.marble.framework.data.inmemory.HintHandler;
import com.poketrirx.marble.teamservice.teams.pub.models.Team;
import com.poketrirx.marble.teamservice.teams.pub.repositories.hints.PageHint;

public final class PageHintHandler implements HintHandler<Team> {
    @Override
    public boolean canHandle(Hint hint) {
        return hint instanceof PageHint;
    }

    @Override
    public Stream<Team> handle(Hint hint, Stream<Team> stream) {
        if (canHandle(hint)) {
            PageHint pageHint = (PageHint) hint;

            return stream.skip(pageHint.getSize() * pageHint.getNumber()).limit(pageHint.getSize());
        }

        return stream;
    }
}
