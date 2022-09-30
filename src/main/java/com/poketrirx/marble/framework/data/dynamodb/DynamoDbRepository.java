package com.poketrirx.marble.framework.data.dynamodb;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import com.poketrirx.marble.framework.data.common.Repository;
import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.data.common.Hint;

@Component
public abstract class DynamoDbRepository<T> implements Repository<T> {
    //private final CriteriaProcessor criteriaProcessor = CriteriaProcessor.builder().build();
    //private final HintProcessor hintProcessor = HintProcessor.builder().build();

    public DynamoDbRepository() {
    }

    @Override
    public ImmutableList<T> get(ImmutableList<Criterion> criteria, ImmutableList<Hint> hints) {
        throw new RuntimeException();
    }

    @Override
    public void delete(ImmutableList<Criterion> criteria, ImmutableList<Hint> hints) {
        throw new RuntimeException();
    }

    @Override
    public T update(T instance) {
        throw new RuntimeException();
    }

    @Override
    public T create(T instance) {
        throw new RuntimeException();
    }
}
