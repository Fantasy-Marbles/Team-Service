package com.poketrirx.marble.framework.data.inmemory;

import java.util.stream.Stream;

import com.google.common.collect.ImmutableList;
import com.poketrirx.marble.framework.data.common.Hint;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;

@Builder
public final class HintProcessor<T> {
    @Singular
    @NonNull
    private final ImmutableList<HintHandler<T>> handlers;

    public Stream<T> process(ImmutableList<Hint> hints, Stream<T> stream) {
        for (Hint hint : hints) {
            for (HintHandler<T> handler: handlers) {
                if (handler.canHandle(hint)) {
                    stream = handler.handle(hint, stream);

                    break;
                }
            }
        }

        return stream;
    }
}
