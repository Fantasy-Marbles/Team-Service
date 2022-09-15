package com.poketrirx.marble.framework.data.inmemory;

import java.util.stream.Stream;

import com.poketrirx.marble.framework.data.common.Criterion;

public interface CriterionHandler<T> {
    boolean canHandle(Criterion criterion);

    Stream<T> handle(Criterion criterion, Stream<T> stream);
}
