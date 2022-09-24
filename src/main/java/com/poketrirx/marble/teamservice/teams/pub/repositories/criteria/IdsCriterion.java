package com.poketrirx.marble.teamservice.teams.pub.repositories.criteria;

import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;

import com.poketrirx.marble.framework.data.common.Criterion;

@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public final class IdsCriterion implements Criterion {
    @Singular
    @Getter
    @NonNull
    private final ImmutableList<String> ids;
}
