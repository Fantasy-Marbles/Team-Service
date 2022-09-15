package com.poketrirx.marble.teamservice.teams.pub.repositories.hints;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import com.poketrirx.marble.framework.data.common.Hint;

@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public final class PageHint implements Hint {
    @Getter
    private final long size;

    @Getter
    private final long number;
}
