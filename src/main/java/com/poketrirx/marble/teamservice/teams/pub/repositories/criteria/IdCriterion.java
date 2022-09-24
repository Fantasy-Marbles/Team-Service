package com.poketrirx.marble.teamservice.teams.pub.repositories.criteria;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import com.poketrirx.marble.framework.data.common.Criterion;

@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
public final class IdCriterion implements Criterion {
    @Getter
    @NonNull
    private final String id;
}
