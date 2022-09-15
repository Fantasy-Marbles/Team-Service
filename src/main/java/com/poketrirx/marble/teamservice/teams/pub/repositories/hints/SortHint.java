package com.poketrirx.marble.teamservice.teams.pub.repositories.hints;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import com.poketrirx.marble.framework.data.common.Hint;

@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public final class SortHint implements Hint {
    @Getter
    @NonNull
    private final String field;

    @Builder.Default
    @Getter
    private final boolean ascending = false;
}
