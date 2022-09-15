package com.poketrirx.marble.framework.data.inmemory;

import java.util.stream.Stream;

import com.poketrirx.marble.framework.data.common.Hint;

public interface HintHandler<T> {
    boolean canHandle(Hint hint);

    Stream<T> handle(Hint hint, Stream<T> stream);
}
