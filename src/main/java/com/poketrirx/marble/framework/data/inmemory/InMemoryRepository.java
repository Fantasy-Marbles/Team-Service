package com.poketrirx.marble.framework.data.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;
import org.springframework.stereotype.Component;

import com.poketrirx.marble.framework.data.common.Repository;
import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.data.common.Hint;

@Component
public abstract class InMemoryRepository<T> implements Repository<T> {
    private final CriteriaProcessor<T> criteriaProcessor;
    private final HintProcessor<T> hintProcessor;
    private final List<T> listData;

    public InMemoryRepository() {
        criteriaProcessor = buildCriteriaProcessor();
        hintProcessor = buildHintProcessor();
        listData = new ArrayList<>();
    }

    @Override
    public ImmutableList<T> get(ImmutableList<Criterion> criteria, ImmutableList<Hint> hints) {
        Stream<T> stream = listData.stream();

        stream = criteriaProcessor.process(criteria, stream);

        stream = hintProcessor.process(hints, stream);

        return ImmutableList.copyOf(stream.iterator());
    }

    @Override
    public void delete(ImmutableList<Criterion> criteria, ImmutableList<Hint> hints) {
        ImmutableList<T> instances = get(criteria, hints);

        synchronized (this) {
            for (T instance : instances) {
                instances.remove(instance);
            }
        }
    }

    @Override
    public T update(T instance) {
        delete(buildGetByIdCriteria(getId(instance)), ImmutableList.of());

        synchronized (this) {
            listData.add(clone(instance));
        }

        return clone(instance);
    }

    @Override
    public T create(T instance) {
        T newInstance = cloneAndSetId(instance, UUID.randomUUID().toString());

        synchronized (this) {
            listData.add(newInstance);
        }

        return clone(newInstance);
    }

    protected abstract ImmutableList<Criterion> buildGetByIdCriteria(String id);

    protected abstract CriteriaProcessor<T> buildCriteriaProcessor();

    protected abstract HintProcessor<T> buildHintProcessor();

    protected abstract String getId(T instance);

    protected abstract T cloneAndSetId(T instance, String id);

    protected abstract T clone(T instance);
}
