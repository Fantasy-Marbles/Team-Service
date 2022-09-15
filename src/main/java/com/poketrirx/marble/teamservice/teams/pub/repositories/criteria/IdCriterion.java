package com.poketrirx.marble.teamservice.teams.pub.repositories.criteria;

import com.poketrirx.marble.framework.data.common.Criterion;
import lombok.*;

@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public final class IdCriterion implements Criterion {
    @Getter
    @NonNull
    private final String id;
}
