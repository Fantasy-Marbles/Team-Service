package com.poketrirx.marble.framework.data.dynamodb;

import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.google.common.collect.ImmutableList;
import com.poketrirx.marble.framework.data.common.Hint;
import lombok.Builder;
import lombok.NonNull;
import lombok.Singular;

@Builder
public final class HintProcessor {
    @Singular
    @NonNull
    private final ImmutableList<HintHandler> handlers;

    public void process(ImmutableList<Hint> hints, QuerySpec querySpec) {
        for (Hint hint : hints) {
            for (HintHandler handler: handlers) {
                if (handler.canHandle(hint)) {
                    handler.handle(hint, querySpec);

                    break;
                }
            }
        }
    }
}
