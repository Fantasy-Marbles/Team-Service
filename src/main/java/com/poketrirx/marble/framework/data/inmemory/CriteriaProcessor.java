package com.poketrirx.marble.framework.data.inmemory;

import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;

import com.poketrirx.marble.framework.data.common.Criterion;
import com.poketrirx.marble.framework.exceptions.BadRequestException;

@Builder
public final class CriteriaProcessor<T> {
    @Singular
    @NonNull
    private final ImmutableList<CriterionHandler<T>> handlers;

    public Stream<T> process(ImmutableList<Criterion> criteria, Stream<T> stream) {
        for (Criterion criterion : criteria) {
            boolean isHandled = false;

            for (CriterionHandler<T> handler: handlers) {
                if (handler.canHandle(criterion)) {
                    isHandled = true;

                    stream = handler.handle(criterion, stream);

                    break;
                }
            }

            if (!isHandled) {
                throw new BadRequestException("Could not process criteria");
            }
        }

        return stream;
    }
}
