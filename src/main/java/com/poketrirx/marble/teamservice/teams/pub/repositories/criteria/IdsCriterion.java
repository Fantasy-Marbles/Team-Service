package com.poketrirx.marble.teamservice.teams.pub.repositories.criteria;

import com.google.common.collect.ImmutableList;
import com.poketrirx.marble.framework.data.common.Criterion;
import lombok.*;

@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public final class IdsCriterion implements Criterion {
    @Singular
    @Getter
    @NonNull
    private final ImmutableList<String> ids;
}
